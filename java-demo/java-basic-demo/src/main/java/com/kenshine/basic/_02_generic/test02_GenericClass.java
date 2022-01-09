package com.kenshine.basic._02_generic;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 9:57
 * @description：
 * @modified By：
 * @version: $
 * 一个普通泛型类
 */
public class test02_GenericClass {
}

//泛型类
class Generic<T>{
    //泛型成员
    private T key;

    //泛型参数
    public Generic(T key){
        this.key = key;
    }

    //泛型返回值
    public T getKey(){
        return key;
    }

    public static void main(String[] args) {
        Generic<Integer> integerG = new Generic<>(11456);
        Generic<String> stringG = new Generic<>("abcde");

        System.out.println(integerG.getKey());
        System.out.println(stringG.getKey());

        //不传类型参数可存储任何类型
        Generic generic1 = new Generic(0);
        Generic generic2 = new Generic(false);
        Generic generic3 = new Generic(123.545);
        System.out.println(generic1.getKey());
        System.out.println(generic2.getKey());
        System.out.println(generic3.getKey());
    }
}
