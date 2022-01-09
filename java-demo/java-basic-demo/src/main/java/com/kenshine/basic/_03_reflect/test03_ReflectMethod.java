package com.kenshine.basic._03_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 14:11
 * @description： 反射获取方法Method
 * @modified By：
 * @version: $
 */
public class test03_ReflectMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class clazz = Class.forName("com.kenshine.basic._03_reflect.Student");

        //获取该类的构造器对象，然后创建Student类的对象
        Constructor con = clazz.getConstructor();
        Student stu = (Student)con.newInstance();

        //获取成员方法和调用
        Method me1 = clazz.getMethod("show1");
        me1.invoke(stu);
        Method me2 = clazz.getMethod("show2",int.class); //int.class
        me2.invoke(stu,1);
        Method me3 = clazz.getDeclaredMethod("show3", int.class, int.class);

        //私有的方法需要再获取一下权限,开启暴力反射
        me3.setAccessible(true);
        int sum = (int)me3.invoke(stu,1,2);
        System.out.println(sum);

        //获取Student类中的所有成员方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
