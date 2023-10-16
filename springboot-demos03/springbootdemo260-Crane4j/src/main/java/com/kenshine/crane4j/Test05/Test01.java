package com.kenshine.crane4j.Test05;

import cn.crane4j.annotation.Disassemble;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description 拆卸操作
 * @Date 2023-10-16 16:16
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {
    // 如果 Employee 对象中还存在需要拆卸的嵌套对象，也会一并取出并展开，一直递归下去，直到所有的对象都被展开为止
    // 在属性上声明
    public class Department {
        private Integer id;
        @Disassemble(type = Employee.class)
        private List<Employee> employees;
    }

    // 直接声明 在类上声明
    @Disassemble(key = "employees", type = Employee.class)
    public class Department1 {
        private Integer id;
        private List<Employee> employees;
    }

    // 递归拆卸 需要自己避免循环引用，否则会栈溢出
    public class Department3 {
        private Integer id;
        private String name;
        @Disassemble(type = Department3.class) // 递归填充下级部门
        private List<Department3> departments3;
    }
}
