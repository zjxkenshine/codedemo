package com.kenshine.basic._02_generic;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 10:22
 * @description：泛型通配符
 * @modified By：
 * @version: $
 */
public class test04_GenericWildcard {
    //未用通配符
    private static void showKeyValue1(Generic<Number> obj){
        System.out.println(obj.getKey());
    }

    //使用通配符
    private static void showKeyValue2(Generic<?> obj){
        System.out.println(obj.getKey());
    }

    //使用通配符 T 为Number子类
    private static void showKeyValue3(Generic<? extends Number> obj){
        System.out.println(obj.getKey());
    }

    //使用通配符 T 为Integer父类
    private static void showKeyValue4(Generic<? super Integer> obj){
        System.out.println(obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(456);

        showKeyValue1(gNumber);
        //无法编译通过
       // showKeyValue1(gInteger);

        //使用通配符 通过
        showKeyValue2(gInteger);
        showKeyValue3(gInteger);
        showKeyValue4(gInteger);
    }
}

