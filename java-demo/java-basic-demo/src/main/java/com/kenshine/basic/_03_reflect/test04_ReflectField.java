package com.kenshine.basic._03_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 14:13
 * @description：反射获取Field
 * @modified By：
 * @version: $
 */
public class test04_ReflectField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Class clazz = Class.forName("com.kenshine.basic._03_reflect.Student");
        Constructor con = clazz.getConstructor();
        Student stu = (Student)con.newInstance();
        //公共域设置
        Field field1 = clazz.getField("name");
        field1.set(stu,"kenshine");
        //静态域设置
        Field field2 = clazz.getDeclaredField("age");
        field2.setAccessible(true);
        field2.set(stu,100);
        System.out.println(stu);
    }
}
