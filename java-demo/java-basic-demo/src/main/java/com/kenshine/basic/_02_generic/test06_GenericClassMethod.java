package com.kenshine.basic._02_generic;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 10:44
 * @description：泛型类中的泛型方法
 * @modified By：
 * @version: $
 *
 * 泛型类中的泛型方法，与泛型类声明的类型参数无关
 */
public class test06_GenericClassMethod {
}

//泛型类
class Generic3<T>{
    private T key;

    public Generic3(T key) {
        this.key = key;
    }
    //成员方法
    public void show_1(T t){
        System.out.println(t.toString());
    }
    //泛型类中的泛型方法
    public <E> void show_3(E t){
        System.out.println(t.toString());
    }
    //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
    public <T> void show_2(T t){
        System.out.println(t.toString());
    }
}



