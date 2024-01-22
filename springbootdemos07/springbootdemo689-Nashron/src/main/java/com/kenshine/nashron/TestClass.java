package com.kenshine.nashron;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname TestClass
 * @Description js调用java静态方法
 * @Date 2024-01-22 9:10
 * @modified By：
 * @version: 1.0$
 */
public class TestClass {
    static String fun1(String name) {
        System.out.format("Hi there from Java, %s", name);
        return "greetings from java";
    }
    /**传递object对象*/
    static void fun2(Object object) {
        System.out.println(object.getClass());
    }
    /**传递js对象*/
    static void fun3(ScriptObjectMirror mirror) {
        System.out.println(mirror.getClassName() + ": " +
                Arrays.toString(mirror.getOwnKeys(true)));
    }
    /**传递js对象*/
    static void fun4(ScriptObjectMirror person) {
        System.out.println("Full Name is: " + person.callMember("getFullName"));
    }
}
