package com.kenshine.typetools.demo02;

import net.jodah.typetools.TypeResolver;

import java.util.function.Function;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 8:58
 * @description：
 * @modified By：
 * @version: $
 */
public class test02 {

    public static void main(String[] args) {
        Function<String, Integer> strToInt = Integer::valueOf;
        //获取实现类对象的具体泛型
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(Function.class, strToInt.getClass());

        System.out.println(typeArgs[0].getName());
        System.out.println(typeArgs[1].getName());
        assert typeArgs[0] == String.class;
        assert typeArgs[1] == Integer.class;

    }
}
