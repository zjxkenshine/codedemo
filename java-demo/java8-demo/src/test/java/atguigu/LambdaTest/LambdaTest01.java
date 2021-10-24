package atguigu.LambdaTest;

import atguigu.LambdaTest.function.MyFun;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 15:01
 * @description：Lambda表达式测试
 * @modified By：
 * @version: $
 *
 * 测试目录：
 * test01~03： 匿名内部类简化为Lambda方法引用
 * test04： 无参数lambda
 * test05:  1参数，无返回值Lambda
 * test06：  两个以上参数，有返回值lambda
 * test07:  自定义函数式接口测试
 * test08:  Lambda表达式用作参数传递
 *
 */
public class LambdaTest01 {

    /**
     * 1.匿名内部类测试
     */
    @Test
    public void test01(){
        //匿名内部类
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        //调用
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }

    /**
     * 2.使用Lambda替换匿名内部类
     * 仅在接口只有一个抽象方法时可以使用Lambda替换匿名内部类（函数式接口）
     */
    @Test
    public void test02(){
        //匿名内部类
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1,o2);
        //调用
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }

    /**
     *  3.简化为静态方法引用
     *  lambda体中调用方法的参数列表和返回值与函数式接口的参数与返回值类型一致时使用
     *  类::静态方法
     *
     *  对应也有：对象引用，构造器引用，数组引用等
     */
    @Test
    public void test03(){
        //匿名内部类
        Comparator<Integer> comparator = Integer::compare;
        //调用
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }

    /**
     * 无参数Lambda
     */
    @Test
    public void test04(){
        //语法糖
        Runnable runnable = () -> {
            System.out.println("Hello Lambda");
        };
        runnable.run();
    }


    /**
     * 一参数，无返回值Lambda
     */
    @Test
    public void test05(){
        /**
         * 基本写法
         */
        Consumer<String> consumer = (a) -> System.out.println(a);
        /**
         * 括号可省略不写
         */
        Consumer<String> consumer1 = a -> System.out.println(a);
        /**
         * 方法引用
         */
        Consumer<String> consumer2 = System.out::println;
        consumer.accept("写法一");
        consumer1.accept("写法二");
        consumer2.accept("写法三");
    }

    /**
     * 两个及以上的参数，有返回值
     *
     */
    @Test
    public void test06(){
        /**
         * Lambda 体中有多条语句
         */
        Comparator<Integer> comparator1 = (a, b) -> {
            System.out.println("比较接口1");
            return Integer.compare(a, b);
        };

        /**
         * Lambda 体中仅一条语句
         * 可以进一步化简为方法引用
         */
        Comparator<Integer> comparator2 = (a, b) -> Integer.compare(a, b);
        //测试
        System.out.println(comparator1.compare(1,2));
        System.out.println("比较接口2  "+comparator2.compare(1,2));
    }

    /**
     * 自定义函数式接口测试
     */
    @Test
    public void test07(){
        MyFun myFun1 = (a, b) -> a + b;
        MyFun myFun2 = (a, b) -> a - b;
        MyFun myFun3 = (a, b) -> a * b;
        MyFun myFun4 = (a, b) -> a / b;
        System.out.println(myFun1.count(6,3));
        System.out.println(myFun2.count(6,3));
        System.out.println(myFun3.count(6,3));
        System.out.println(myFun4.count(6,3));
    }


    public Integer operation(Integer a, Integer b, MyFun myFun){
        return myFun.count(a, b);
    }

    /**
     * Lambda表达式用作参数传递
     * 声明并实例化一个myFun匿名类对象
     */
    @Test
    public void test08(){
        //Integer result = operation(1, 2, (x, y) -> x + y);
        Integer result = operation(1, 2, Integer::sum);
        System.out.println(result);
    }




}
