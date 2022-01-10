package com.kenshine.basic._09_Collection;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:21
 * @description：
 * @modified By：
 * @version: $
 * TreeSet 是一个有序的集合，它的作用是提供有序的Set集合
 * TreeSet是基于TreeMap实现的
 */
public class Test10_TreeSet {
     public static void main(String[] args) {
         TreeSet set = new TreeSet();
         set.add("aaa");
         set.add("aaa");
         set.add("bbb");
         set.add("eee");
         set.add("ddd");
         set.add("ccc");

         // 顺序遍历TreeSet
         ascIteratorThroughIterator(set) ;
        // 逆序遍历TreeSet
        descIteratorThroughIterator(set);
        // 通过for-each遍历TreeSet。不推荐！此方法需要先将Set转换为数组
         foreachTreeSet(set);
     }

     // 顺序遍历TreeSet
     public static void ascIteratorThroughIterator(TreeSet set) {
         System.out.print("\n ---- Ascend Iterator ----\n");
         for(Iterator iter = set.iterator(); iter.hasNext(); ) {
             System.out.printf("asc : %s\n", iter.next());
         }
     }

     // 逆序遍历TreeSet
     public static void descIteratorThroughIterator(TreeSet set) {
         System.out.printf("\n ---- Descend Iterator ----\n");
        for(Iterator iter = set.descendingIterator(); iter.hasNext();){
            System.out.printf("desc : %s\n", (String) iter.next());
        }
     }

     // 通过for-each遍历TreeSet。不推荐！此方法需要先将Set转换为数组
     private static void foreachTreeSet(TreeSet set) {
         System.out.printf("\n ---- For-each ----\n");
         String[] arr = (String[])set.toArray(new String[0]);
         for (String str:arr) {
             System.out.printf("for each : %s\n", str);
         }
    }
}
