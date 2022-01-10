package com.kenshine.basic._09_Collection;

import java.util.HashSet;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 21:32
 * @description：
 * @modified By：
 * @version: $
 */
public class Test03_HashSet {
    public static void main(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Kenshine");
        sites.add("Qin");
        sites.add("Piffou");
        sites.add("Zax");
        // 重复的元素不会被添加
        sites.add("Zax");
        //无序
        for (String i : sites) {
            System.out.println(i);
        }
    }
}
