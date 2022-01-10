package com.kenshine.basic._09_Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 23:10
 * @description：
 * @modified By：
 * @version: $
 * IdentityHashMap 允许保存相同的key
 * IdentityHashMap不是Map的通用实现，它有意违反了Map的常规协定。并且IdentityHashMap允许key和value都为null
 *
 * 同HashMap，IdentityHashMap也是无序的，并且该类不是线程安全的，
 * 如果要使之线程安全，可以调用Collections.synchronizedMap(new IdentityHashMap(…))方法来实现
 */
public class Test19_IdentityHashMap {
    public static void main(String[] args) {
        //HashMap
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("a", "2");
        map.put("a", "3");
        System.out.println(map.size()); //1

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(new String("a"), "1");
        hashMap.put(new String("a"), "2");
        hashMap.put(new String("a"), "3");
        System.out.println(hashMap.size()); //1

        Map<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(new Integer(200), "1");
        hashMap2.put(new Integer(200), "2");
        hashMap2.put(new Integer(200), "3");
        System.out.println(hashMap2.size()); //1

        Map<Demo, String> hashMap3 = new HashMap<>();
        hashMap3.put(new Demo(1), "1");
        hashMap3.put(new Demo(1), "2");
        hashMap3.put(new Demo(1), "3");
        System.out.println(hashMap3.size()); //1

        //IdentityHashMap使用===================================
        System.out.println("IdentityHashMap使用===================================");
        Map<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new String("a"), "1");
        identityHashMap.put(new String("a"), "2");
        identityHashMap.put(new String("a"), "3");
        System.out.println(identityHashMap.size()); //3

        Map<Demo, String> identityHashMap2 = new IdentityHashMap<>();
        identityHashMap2.put(new Demo(1), "1");
        identityHashMap2.put(new Demo(1), "2");
        identityHashMap2.put(new Demo(1), "3");
        System.out.println(identityHashMap2.size()); //3
    }
}
@Data
@AllArgsConstructor
class Demo{
    int i;
}
