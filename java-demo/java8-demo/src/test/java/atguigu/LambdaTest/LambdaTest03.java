package atguigu.LambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 15:57
 * @description：函数式接口测试
 * @modified By：
 * @version: $
 *
 * test01: 消费型接口    Consumer<T>
 * test02: 提供型接口    Supplier<T>
 * test03:  函数型接口   Function<T, R> T:参数类型，R:返回类型
 * test04:  断言型接口   Predicate 返回值为布尔类型
 *
 * 其他函数式接口在 java.util.function内
 * 如: LongFunction<T> , BiConsumer<T,U> 等等
 *
 */
public class LambdaTest03 {


    /**
     * 消费型接口
     */
    @Test
    public void test01(){
        //Consumer 消费型接口 1进0出
        Consumer<Integer> consumer = (x) -> System.out.println("消费型接口" + x);
        //test
        consumer.accept(100);
    }

    /**
     * 提供型接口
     */
    @Test
    public void test02(){
        List<Integer> integers = Arrays.asList(1,2,3);
        List<Integer> list = new ArrayList<>(integers);
        //Supplier<T> 提供型接口  0进1出
        Supplier<Integer> supplier = () -> (int)(Math.random() * 10);
        list.add(supplier.get());
        System.out.println(supplier.get());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 函数型接口  Function<T, R> T:入参类型，R:返回类型
     */
    @Test
    public void test03(){
        //Function<T, R>   函数型接口
        String oldStr = "abc123456xyz";
        //去掉头尾
        Function<String, String> function = (s) -> s.substring(1, s.length()-1);
        //test
        System.out.println(function.apply(oldStr));
    }

    /**
     * 断言型接口，返回值为布尔类型
     */
    @Test
    public void test04(){
        //Predicate<T> 断言型接口
        Integer age = 35;
        Predicate<Integer> predicate = (i) -> i >= 35;
        if (predicate.test(age)){
            System.out.println("你该退休了");
        } else {
            System.out.println("我觉得还OK啦");
        }
    }




}
