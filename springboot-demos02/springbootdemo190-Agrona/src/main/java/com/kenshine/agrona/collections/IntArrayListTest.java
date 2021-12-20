package com.kenshine.agrona.collections;

import org.agrona.collections.IntArrayList;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 14:03
 * @description：
 * @modified By：
 * @version: $
 */
public class IntArrayListTest {
    public static void main(String[] args) {
        IntArrayList intArrayList = new IntArrayList();
        intArrayList.addInt(1);
        intArrayList.addInt(2);
        intArrayList.addInt(4);
        intArrayList.addInt(9);
        System.out.println(intArrayList);
    }
}
