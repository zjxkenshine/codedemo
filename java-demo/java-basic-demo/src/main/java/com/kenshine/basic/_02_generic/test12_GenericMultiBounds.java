package com.kenshine.basic._02_generic;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 12:13
 * @description： 泛型多限定类型擦除
 * @modified By：
 * @version: $
 */
public class test12_GenericMultiBounds {
    public static void main(String[] args) {
        _12B test = new _12B<>(new _12C());
        //这里不会擦除 擦除是虚拟机中的效果
        System.out.println(test.get().getClass());
    }
}

//慢慢理解 T类型擦除后为 _12A<Comparator<Comparable<List<Optional<Number>>>>
class _12A<T extends Comparator<? super Comparable<? extends List<? extends Optional<? extends Number>>>>&Serializable>{
}

//类型擦除后T 为Number类型
class _12B<T extends Number&Serializable>{
    private T t;
    public _12B(T t){
        this.t = t;
    }
    public T get(){
      return t;
    }
}


class _12C extends Number implements Serializable{
    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}