package com.kenshine.basic._09_Collection;

import java.util.LinkedList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 21:27
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> sites = new LinkedList<>();
        sites.add("Kenshine");
        sites.add("Qin");
        sites.add("Bin");
        sites.add("Kin");
        // 使用 removeFirst() 移除头部元素
        sites.removeFirst();
        System.out.println(sites);

        //遍历
        for (int size = sites.size(), i = 0; i < size; i++) {
            System.out.println(sites.get(i));
        }
        for (String i : sites) {
            System.out.println(i);
        }

        //删除并并返回第一个元素
        System.out.println(sites.poll());
    }
}
