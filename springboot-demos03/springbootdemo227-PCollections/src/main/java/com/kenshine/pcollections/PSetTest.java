package com.kenshine.pcollections;

import org.pcollections.HashTreePSet;
import org.pcollections.PSet;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/17 15:17
 * @description：
 * @modified By：
 * @version: $
 */
public class PSetTest {
    public static void main(String[] args) {
        PSet<String> set = HashTreePSet.empty();
        set = set.plus("aaaaa");

        System.out.println(set);
        System.out.println(set.plus("bbbbb"));
        System.out.println(set);
    }
}
