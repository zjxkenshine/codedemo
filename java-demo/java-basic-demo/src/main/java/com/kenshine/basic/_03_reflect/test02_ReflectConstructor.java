package com.kenshine.basic._03_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 13:36
 * @description： 反射获取构造方法
 * @modified By：
 * @version: $
 */
public class test02_ReflectConstructor {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        // 第1步：获取Student类的字节码文件对象
        Class clazz = Class.forName("com.kenshine.basic._03_reflect.Student");

        // 第2步：获取指定的构造器对象
        // 2.1获取公共的无参构造
        Constructor con1 = clazz.getConstructor();
        // 2.2获取公共的有参数构造
        Constructor con2 = clazz.getConstructor(String.class);
        // 2.3获取私有的有参数构造
        Constructor con3 = clazz.getDeclaredConstructor(int.class);
        // 2.4获取所有公共的构造函数
        Constructor[] cons = clazz.getConstructors();

        //查看构造器属于哪个类
        //String name = con2.getName();
        //System.out.println(name);

        // 第3步：根据构造器对象和参数，创建对应的Student对象
        Student stu = (Student)con2.newInstance("kenshine");
        System.out.println(stu);

        // 第4步：打印结果
        System.out.println("***********");
        System.out.println(con1);
        System.out.println(con2);
        System.out.println(con3);
        System.out.println("*******************");
        for(Constructor con:cons){
            System.out.println(con);
        }
    }
}
