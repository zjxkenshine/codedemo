package com.kenshine.chapter06;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 22:14
 * @description：Unsafe获取
 * @modified By：
 * @version: $
 */
public class Test12_Unsafe01{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Unsafe 使用了单例模式，unsafe 对象是类中的一个私有的变量
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
    }
}
