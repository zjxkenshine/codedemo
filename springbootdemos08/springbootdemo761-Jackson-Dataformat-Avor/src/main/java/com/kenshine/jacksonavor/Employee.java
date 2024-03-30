package com.kenshine.jacksonavor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname Employee
 * @Description 测试类
 * @Date 2024-03-30 8:55
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    public String name;
    public int age;
    public String[] emails;
    public Employee boss;
}
