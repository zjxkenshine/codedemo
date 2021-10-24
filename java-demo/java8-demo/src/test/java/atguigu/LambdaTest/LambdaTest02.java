package atguigu.LambdaTest;

import atguigu.LambdaTest.demo01.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 15:51
 * @description：Lambda案例测试
 * @modified By：
 * @version: $
 *
 */
public class LambdaTest02 {
   private List<Employee> emps = Arrays.asList(
            new Employee(101, "Z3", 19, 9999.99),
            new Employee(102, "L4", 20, 7777.77),
            new Employee(103, "W5", 35, 6666.66),
            new Employee(104, "Tom", 44, 1111.11),
            new Employee(105, "Jerry", 60, 4444.44)
    );

    /**
     * 测试排序
     * 先按年龄再按名字
     */
    @Test
    public void  test01(){
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }


}
