package com.kenshine.reflections.test02;

/**
 * @author by kenshine
 * @Classname TestCons
 * @Description 构造函数注解
 * @Date 2023-10-17 15:38
 * @modified By：
 * @version: 1.0$
 */
public class TestCons {
    @SomeAnnotation
    public int a;

    @SomeAnnotation
    public TestCons(int a){
        this.a=a;
    }

    public void test01(@SomeAnnotation int a){
        System.out.println("参数注解");
    }
}
