package com.kenshine.basic._09_Collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 21:53
 * @description：
 * @modified By：
 * @version: $
 * 所谓LinkedHashMap，其落脚点在HashMap，因此更准确地说，它是一个将所有Entry节点链入一个双向链表的HashMap
 *  LinkedHashMap的默认实现是按插入顺序排序的
 *
 *  以HashMap维护数据结构，以LinkList的方式维护数据插入顺序
 *
 *  利用LinkedHashMap实现LRU算法缓存
 */
public class Test07_LinkedHashMap extends LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> mapPerson = new LinkedHashMap<>(16, 0.75f, false);
        mapPerson.put("p1", 1);
        mapPerson.put("p2", 2);
        mapPerson.put("p3", 3);
        mapPerson.get("p4");
        mapPerson.get("p5");

        Iterator<Map.Entry<String, Integer>> iter = mapPerson.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> e = iter.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }

    }
}
