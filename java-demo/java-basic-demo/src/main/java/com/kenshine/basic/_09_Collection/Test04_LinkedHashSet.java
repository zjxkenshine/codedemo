package com.kenshine.basic._09_Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 21:34
 * @description：
 * @modified By：
 * @version: $
 * LinkedHashSet集合同样是根据元素的hashCode值来决定元素的存储位置，但是它同时使用链表维护元素的次序
 * LinkedHashSet在迭代访问Set中的全部元素时，性能比HashSet好，但是插入时性能稍微逊色于HashSet
 */
public class Test04_LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> sites = new LinkedHashSet<>();
        sites.add("Kenshine");
        sites.add("Qin");
        sites.add("Piffou");
        sites.add("Zax");
        // 重复的元素不会被添加
        sites.add("Zax");
        //有序
        for (String i : sites) {
            System.out.println(i);
        }
    }
}
