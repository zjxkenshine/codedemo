package com.kenshine.ordered.demo02;

import org.springframework.core.OrderComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 10:29
 * @description：排序比较器测试
 * @modified By：
 * @version: $
 */
public class OrderedComparatorTest {

    public static void main(String[] args) {
        Comparator<Object> comparator = new OrderComparator().withSourceProvider(new TestProvider());

        //可以通过修改TestProvider的方法返回值控制比较的值
        System.out.println(comparator.compare("a","b"));
        //排序不受TestProvider影响
        List<String> sort = Arrays.asList("a","b");
        OrderComparator.sort(sort);
        System.out.println(sort);
    }

}
