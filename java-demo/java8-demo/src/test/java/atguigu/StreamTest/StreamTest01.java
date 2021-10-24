package atguigu.StreamTest;

import atguigu.LambdaTest.demo01.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 17:23
 * @description：Stream 三大操作测试   创建，中间操作
 * @modified By：
 * @version: $
 *
 * Stream是一种数据渠道，用于操作数据源(集合，数组等)生成的元素序列
 *
 *  test01： 创建流的几种方式
 *
 *  test02： 中间操作： 筛选 / 切片
 *  test03： 中间操作： map映射
 *  test04： 中间操作： flatMap映射
 *  test05： 中间操作： 自然排序 sorted()
 *  test06： 中间操作： 定制排序 sorted(Comparator c)
 *
 *  test07： 终止操作： 查找 / 匹配
 *  StreamTest02: 终止操作：归约/收集
 *
 *
 *
 */
public class StreamTest01 {

    /**
     * 创建流的几种方式
     */
    @Test
    public void test01(){
        /**
         * 集合流
         *  - Collection.stream() 穿行流
         *  - Collection.parallelStream() 并行流
         */
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //数组流
        //Arrays.stream(array)
        String[] strings = new String[10];
        Stream<String> stream2 = Arrays.stream(strings);

        //Stream 静态方法
        //Stream.of(...)
        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        //无限流
        //迭代 iterate方法
        Stream<Integer> stream4 = Stream.iterate(0, (i) -> ++i+i++);
        stream4.forEach(System.out::println);

        //generate方法生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }


    List<Employee> emps = Arrays.asList(
            new Employee(101, "Z3", 19, 9999.99),
            new Employee(102, "L4", 20, 7777.77),
            new Employee(103, "W5", 35, 6666.66),
            new Employee(104, "Tom", 44, 1111.11),
            new Employee(105, "Jerry", 60, 4444.44)
    );

    /**
     * 中间操作： 筛选 / 切片
     * filter：接收 Lambda ，从流中排除某些元素
     * limit：截断流，使其元素不超过给定数量
     * skip(n)：跳过元素，返回一个舍弃了前n个元素的流；若流中元素不足n个，则返回一个空流；与 limit(n) 互补
     * distinct：筛选，通过流所生成的 hashCode() 与 equals() 取除重复元素
     *
     */
    @Test
    public void test02(){
        emps.stream()
                .filter((x) -> x.getAge() > 35)
                .limit(3) //短路？达到满足不再内部迭代
                .distinct()
                .skip(1)
                .forEach(System.out::println);

    }


    /**
     * 中间操作： map映射
     * map： 接收 Lambda ，将元素转换为其他形式或提取信息；接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     */
    @Test
    public void test03(){
        List<String> list = Arrays.asList("aaa", "b", "c");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
    }


    public Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }

    /**
     *  中间操作： flatMap映射
     *  接收一个函数作为参数，将流中每一个值都换成另一个流，然后把所有流重新连接成一个流
     */
    @Test
    public void test04(){
        List<String> list = Arrays.asList("aaa", "b", "c");
        StreamTest01 streamTest = new StreamTest01();
        list.stream()
                //生成了三个流
                .flatMap(streamTest::filterCharacter)
                .forEach(System.out::println);
    }


    /**
     * 中间操作:自然排序
     * sorted()：自然排序
     * sorted(Comparator c)：定制排序
     */
    @Test
    public void test05(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .sorted() //comparaTo()
                .forEach(System.out::println);
    }

    /**
     * 中间操作:定制排序
     * sorted()：自然排序
     * sorted(Comparator c)：定制排序
     */
    @Test
    public void test06(){
        emps.stream()
                .sorted((e1, e2) -> { //compara()
                    if (e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }

    /**
     * 终止操作：查找 / 匹配
     * allMatch：检查是否匹配所有元素
     * anyMatch：检查是否至少匹配一个元素
     * noneMatch：检查是否没有匹配所有元素
     * findFirst：返回第一个元素
     * findAny：返回当前流中的任意元素
     * count：返回流中元素的总个数
     * max：返回流中最大值
     * min：返回流中最小值
     */
    @Test
    public void test07(){
        List<Status> list = Arrays.asList(Status.FREE, Status.BUSY, Status.VOCATION);

        boolean flag1 = list.stream()
                .allMatch((s) -> s.equals(Status.BUSY));
        System.out.println(flag1);

        boolean flag2 = list.stream()
                .anyMatch((s) -> s.equals(Status.BUSY));
        System.out.println(flag2);

        boolean flag3 = list.stream()
                .noneMatch((s) -> s.equals(Status.BUSY));
        System.out.println(flag3);

        // 避免空指针异常
        Optional<Status> op1 = list.stream()
                .findFirst();
        // 如果Optional为空 找一个替代的对象
        Status s1 = op1.orElse(Status.BUSY);
        System.out.println(s1);

        Optional<Status> op2 = list.stream()
                .findAny();
        System.out.println(op2);

        long count = list.stream()
                .count();
        System.out.println(count);
    }

}
