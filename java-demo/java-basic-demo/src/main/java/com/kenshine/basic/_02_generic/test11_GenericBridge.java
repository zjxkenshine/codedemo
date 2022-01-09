package com.kenshine.basic._02_generic;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 11:54
 * @description：
 * @modified By：
 * @version: $
 */
public class test11_GenericBridge {
    public static void main(String[] args) {
       B b = new B("这是擦除类型后生成的方法");
       //优先调用自己的方法
       System.out.println(b.get());
    }

}


class A<T>{
    private T t;
    public A(T t){
        this.t = t;
    }

    public T get(){
        //不能new T
        //return new T();
        return t;
    }
}

class B extends A<String>{

    public B(String s) {
        super(s);
    }

    //A中 T get() 类型擦除后方法为Object get();
    public String get(){
        return "这是B自己的方法";
    }

    //这种写法错误，回和桥方法冲突 A中类型擦除后方法为Object get()
//    public Object get(){
//        return t;
//    }
}


