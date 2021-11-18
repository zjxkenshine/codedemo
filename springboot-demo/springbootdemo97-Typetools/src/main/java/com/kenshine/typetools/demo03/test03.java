package com.kenshine.typetools.demo03;

import net.jodah.typetools.TypeResolver;

import java.util.Comparator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 9:00
 * @description：测试3
 * @modified By：
 * @version: $
 */
public class test03 {

    public static void main(String[] args) {
        Comparator<String> comparator = String::compareToIgnoreCase;
        //单个泛型具体类型
        Class<?> typeArg = TypeResolver.resolveRawArgument(Comparator.class, comparator.getClass());

        System.out.println(typeArg.getName());
        assert typeArg == String.class;
    }

}
