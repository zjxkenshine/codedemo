package atguigu.LambdaTest;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 16:10
 * @description：方法引用测试
 * @modified By：
 * @version: $
 *
 * 若 Lambda 表达式体中的内容已有方法实现，则我们可以使用“方法引用
 *
 *
 *  test01: 对象::实例方法
 *  test02: 类::静态方法
 *  test03: 类::实例方法
 *  test04: 构造器引用
 *  test05: 数组引用
 */
public class LambdaTest04 {

    /**
     *
     * 对象::实例方法
     *
     * Lambda 表达实体中调用方法的参数列表、返回类型必须和函数式接口中抽象方法保持一致
     */
    @Test
    public void test01(){
        PrintStream ps = System.out;
        Consumer<String> con1 = (s) -> ps.println(s);
        con1.accept("aaa");

        Consumer<String> con2 = ps::println;
        con2.accept("bbb");
    }

    /**
     * 类：:静态方法
     */
    @Test
    public void test02(){
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(1, 2));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(1, 2));
    }

    /**
     * 类::实例方法
     */
    @Test
    public void test03(){
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        System.out.println(bp1.test("a","b"));

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("c","c"));
    }

    /**
     * 构造器引用
     * type:new
     */
    @Test
    public void test04(){
        Supplier<List> sup1 = () -> new ArrayList();
        Supplier<List> sup2 = ArrayList::new;
    }

    /**
     * 数组引用
     * type[]::new;
     */
    @Test
    public void test05(){
        Function<Integer,String[]> fun= x ->new String[x];
        String[] str=fun.apply(3);
        System.out.println(str.length);
        Function<Integer,String[]> fun2=String[]::new;
        String[] str2=fun2.apply(4);
        System.out.println(str2.length);
    }





}
