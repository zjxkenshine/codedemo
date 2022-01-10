package com.kenshine.basic._09_Collection;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 23:19
 * @description：
 * @modified By：
 * @version: $
 * 子视图相关接口
 * SortedSet声明了三个方法
 * subSet(E from, E to)：子视图集合
 * headSet(E to)：头部子视图
 * tailSet(E from)：尾部子视图
 *
 * Java 6 引人的 NavigableSet 接口赋予子范围操作更多的控制能力，如可指定是否包括边界
 */
public class Test20_NavigableSet {
    public static void main(String[] args) {
        //利用实现了NavigableSet的TreeSet做实验
        NavigableSet<String> sortedTreeSet = new TreeSet<>(); // SortedSet接收TreeSet的实例
        // 增加元素
        sortedTreeSet.add("aa");
        sortedTreeSet.add("bb");
        sortedTreeSet.add("cc");
        sortedTreeSet.add("dd");
        sortedTreeSet.add("ee");

        System.out.println(sortedTreeSet.size());//5个元素：5
        System.out.println( sortedTreeSet.ceiling("cc"));//大于等于cc的最小值，不存在返回null：cc
        System.out.println(sortedTreeSet.descendingSet());//返回Set的逆序视图：[ee, dd, cc, bb, aa]
        System.out.println(sortedTreeSet.floor("cc"));//返回小于等于cc的元素的最大值，不存在返回null：cc
        System.out.println( sortedTreeSet.headSet("cc"));//返回元素小于cc的元素：[aa,bb]
        System.out.println( sortedTreeSet.headSet("cc", true));//返回元素小于等于cc的元素视图:[aa,bb,cc]

        System.out.println(sortedTreeSet.higher("cc"));//返回大于给定元素的最小元素:dd
        System.out.println( sortedTreeSet.lower("cc"));//返回小于cc的最大元素:bb
        System.out.println(sortedTreeSet.pollFirst());//移除第一个元素:aa
        System.out.println(sortedTreeSet.pollLast());//移除最后一个元素:ee
        System.out.println( sortedTreeSet.subSet("aa",true,"dd",true));//返回部分视图，true表示包括当前元素:[bb,cc,dd]
        System.out.println( sortedTreeSet.subSet("bb","dd"));//返回部分视图包括前面的，不包括后面的:[bb,cc]
        System.out.println( sortedTreeSet.tailSet("cc"));//返回元素大于cc的元素视图,包括cc:[cc,dd]
        System.out.println( sortedTreeSet.tailSet("cc", false));//返回元素大于等于cc的元素视图:[dd]
        System.out.println( sortedTreeSet.iterator());//返回set上的升序排序的迭代器
        System.out.println( sortedTreeSet.descendingIterator());//返回set上的降序排序的迭代器

        System.out.println("=====================================");
    }
}
