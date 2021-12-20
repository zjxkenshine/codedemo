package com.kenshine.agrona.collections;

import org.agrona.collections.Int2IntHashMap;
import org.agrona.collections.Int2ObjectHashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 13:54
 * @description：Agrona的Map集合
 * @modified By：
 * @version: $
 */
public class MapTest {
    public static void main(String[] args) {
        Int2IntHashMap intHashMap = new Int2IntHashMap(0);
        intHashMap.put(1,2);
        intHashMap.put(2,4);
        intHashMap.put(3,9);
        System.out.println(intHashMap);

        Int2ObjectHashMap int2ObjectHashMap = new Int2ObjectHashMap();
        int2ObjectHashMap.put(1,new User("1","kenshine"));
        int2ObjectHashMap.put(2,new User("2","qin"));
        System.out.println(int2ObjectHashMap);
    }
}
