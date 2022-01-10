package com.kenshine.basic._09_Collection;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 23:02
 * @description：
 * @modified By：
 * @version: $
 *
 * 枚举集（EnumSet）是一个枚举类型元素集的高效实现，内部用位序列实现。如果对应的值在集中，则相应的位被置为1：
 *
 * EnumMap 是一个键类型为枚举类型的映射。它可以直接且高效地用一个值数组实现
 */
public class Test18_EnumSet {

    public static void main(String[] args) {
        //枚举集三种创建方式
        EnumSet<TYPE> a = EnumSet.allOf(TYPE.class);
        EnumSet<TYPE> b = EnumSet.noneOf(TYPE.class);
        EnumSet<TYPE> c = EnumSet.of(TYPE.A,TYPE.C);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //枚举映射的使用
        EnumMap<TYPE, Integer> enumMap = new EnumMap<>(TYPE.class);
        enumMap.put(TYPE.A,1);
        enumMap.put(TYPE.B,2);
        enumMap.put(TYPE.C,3);
        System.out.println(enumMap);
    }
}
enum TYPE{ A , B , C }
