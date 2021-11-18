package com.kenshine.typetools.demo01;

import net.jodah.typetools.TypeResolver;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 8:56
 * @description：测试1
 * @modified By：
 * @version: $
 */
public class test01 {
    public static void main(String[] args) {
        //获取实现类泛型的具体类型
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(Foo.class, Bar.class);

        System.out.println(typeArgs[0].getName());
        System.out.println(typeArgs[1].getName());
        assert typeArgs[0] == Integer.class;
        assert typeArgs[1] == String.class;
    }
}
