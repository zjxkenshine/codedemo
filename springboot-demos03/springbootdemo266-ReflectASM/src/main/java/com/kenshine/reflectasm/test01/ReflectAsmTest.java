package com.kenshine.reflectasm.test01;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname ReflectAsmTest
 * @Description 对比Java反射
 * @Date 2023-10-17 10:30
 * @modified By：
 * @version: 1.0$
 */
public class ReflectAsmTest {
    public static void main(String[] args) throws Exception {
        // java reflection
        Class<User> clazz = User.class;
        Field field = clazz.getField("name");
        field.setAccessible(true);
        Method method = clazz.getMethod("setName", String.class);
        method.setAccessible(true);

        // reflection asm
        ConstructorAccess<User> ca = ConstructorAccess.get(clazz);
        FieldAccess fa = FieldAccess.get(User.class);
        MethodAccess ma = MethodAccess.get(User.class);

        // use for test
        User user = new User();
        int times = 100000000;

        // case0: common
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = new User();
            user.name = "zjx";
            user.setName("kenshine");
        }
        System.out.println("common : " + (System.currentTimeMillis() - startTime0));

        // case1: java reflect
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = clazz.newInstance();
            field.set(user, "zjx");
            method.invoke(user, "kenshine");
        }
        System.out.println("java reflect : " + (System.currentTimeMillis() - startTime1));

        // case2: 名称
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = ca.newInstance();
            fa.set(user, "name", "zjx");
            ma.invoke(user, "setName", "kenshine");
        }
        System.out.println("reflectasm use name : " + (System.currentTimeMillis() - startTime2));

        // case3: 索引
        int index1 = fa.getIndex("name");
        int index2 = ma.getIndex("setName");
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            user = ca.newInstance();
            fa.set(user, index1, "zjx");
            ma.invoke(user, index2, "kenshine");
        }
        System.out.println("reflectasm use index : " + (System.currentTimeMillis() - startTime3));
    }


}
