package com.kenshine.basic._09_Collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:29
 * @description：
 * @modified By：
 * @version: $
 *
 * Java Iterator（迭代器）不是一个集合，它是一种用于访问集合的方法，可用于迭代 ArrayList 和 HashSet 等集合
 */
public class Test12_Iterator {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");

        // 获取迭代器
        Iterator<String> it = sites.iterator();

        // 输出集合中的第一个元素
        System.out.println(it.next());

        // 输出集合中的所有元素
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
