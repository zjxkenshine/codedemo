package atguigu.StreamTest;

import atguigu.LambdaTest.demo01.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 18:17
 * @description：Stream案例
 * @modified By：
 * @version: $
 *
 */
public class StreamTest03 {

    /**
     * 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢
     */
    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .map((x) -> x * x)
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
     *  使用 map 和 reduce 数一数流中有多少个 Employee
     */
    @Test
    public void test02() {
        Optional<Integer> result = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(result.get());
    }

}
