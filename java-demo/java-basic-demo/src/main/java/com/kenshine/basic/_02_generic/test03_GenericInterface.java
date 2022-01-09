package com.kenshine.basic._02_generic;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 10:09
 * @description：泛型接口
 * @modified By：
 * @version: $
 */
public class test03_GenericInterface {
    public static void main(String[] args) {
    }
}


//泛型接口
interface Generator<T> {
    public T get();
}



//未确定类型参数T的实现 子类也需要带类型参数
class WhatSupplier<T> implements Generator<T> {
    @Override
    public T get() {
        return null;
    }
}



//已确定类型参数T的实现
class StringSupplier implements Generator<String>{
    @Override
    public String get() {
        return "abc";
    }
}