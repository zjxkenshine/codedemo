package com.kenshine.basic._09_Collection;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:03
 * @description：
 * @modified By：
 * @version: $
 * WeakHashMap就是基于弱引用
 * 强引用 一个对象具有强引用，它就不会被垃圾回收器回收
 * 软引用 内存足够的时候，软引用对象不会被回收，只有在内存不足时，系统则会回收软引用对象，如果回收了软引用对象之后仍然没有足够的内存，才会抛出内存溢出异常
 * 弱引用 如果一个对象具有弱引用，在垃圾回收时候，一旦发现弱引用对象，无论当前内存空间是否充足，都会将弱引用回收
 * 虚引用 如果一个对象具有虚引用，就相当于没有引用，在任何时候都有可能被回收
 *
 *
 * 不要使用基础类型作为WeakHashMap的key
 * 那些Key <= 127的Entry将不会进行自动回收，但是那些大于127的将会被回收，因此最后的尺寸总是会稳定在128左右
 */
public class Test08_WeakHashMap {
    public static void main(String[] args) {
        Map<Integer, Byte[]> map = null;

        map = new WeakHashMap<>();
        for (int i = 0; i < 10000; i++) {
            Integer integer = new Integer(i);
            map.put(integer, new Byte[i]);
        }
        //-Xmx5M 这个时候发现没有OOM

        // -Xmx5M java.lang.OutOfMemoryError: Java heap space
        map = new HashMap<>(10);
        for (int i = 0; i < 100; i++) {
            Integer integer = new Integer(i);
            map.put(integer, new Byte[i]);
        }

        //如果存放在WeakHashMap中的key都存在强引用，那么WeakHashMap就会退化为HashMap。
        // -Xmx5M java.lang.OutOfMemoryError: Java heap space
        // at cn.intsmaze.collection.MapCase.testWeakHash(MapCase.java:119)
        map = new WeakHashMap<>();
        List list = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            Integer integer = new Integer(i);
            // 如果你看不起我，你可以把这行注释，你将会发现姜还是老的辣，内存溢出是WeakHashMap而不是List导致.
            map.put(integer, new Byte[i]);
            list.add(integer);
        }
    }
}
