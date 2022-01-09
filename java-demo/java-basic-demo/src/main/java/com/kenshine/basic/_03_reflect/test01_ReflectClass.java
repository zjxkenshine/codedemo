package com.kenshine.basic._03_reflect;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 13:33
 * @description： 反射01
 * @modified By：
 * @version: $
 *
 * 获取Class的三种方式
 */
public class test01_ReflectClass {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方式一 运行时阶段
        Student stu = new Student();
        Class clazz1 = stu.getClass();
        // 方式二 类对象阶段
        Class clazz2 = Student.class;
        // 方式三 源码阶段
        Class clazz3 = Class.forName("com.kenshine.basic._03_reflect.Student");

        System.out.println(clazz1.equals(clazz2));
        System.out.println(clazz2.equals(clazz3));
    }
}
