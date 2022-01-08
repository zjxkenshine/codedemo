package com.kenshine.basic._01_base;

//父类
class A {
    static int i=0;
    static {
        System.out.println("静态代码块A");
    }
    public A(){
        System.out.println("构造方法A");
    }

    {
        System.out.println("代码块A");
    }

    static {
        i++;
        System.out.println("在类A中静态变量i="+i);
    }
}


class B extends A{
    static {
        System.out.println("静态代码块B");
    }
    public B(){
        System.out.println("构造方法B");
    }

    {
        System.out.println("代码块B");
    }

    public static void main(String[] args) {
        System.out.println("main方法");
        new B();
        System.out.println("--------------------");
        new B();
    }

    static {
        i++;
        System.out.println("在类B中静态变量i="+i);
    }
}