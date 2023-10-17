package com.kenshine.reflections;

/**
 * @author by kenshine
 * @Classname User
 * @Description 测试
 * @Date 2023-10-17 15:01
 * @modified By：
 * @version: 1.0$
 */
@MyAnnotation
public class User {
    @MyAnnotation
    private String name;

    @MyAnnotation
    public void getName(){
        System.out.println("kenshine");
        System.out.println(name);
    }
}
