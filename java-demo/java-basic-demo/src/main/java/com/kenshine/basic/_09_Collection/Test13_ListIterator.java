package com.kenshine.basic._09_Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 22:31
 * @description：
 * @modified By：
 * @version: $
 * listiterator 是一个强大的iterator子类型,能用于各种list类的访问.比如 双向移动,修改指定下标的值.
 * 比lierator多了很多功能,算是iterator一个加强版本
 */
public class Test13_ListIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator<Integer> it = list.listIterator();
        //向后遍历
        while (it.hasNext()) {
            System.out.println(it.next()); //  1 2 3
        }
        //向前遍历
        while (it.hasPrevious()) {
            System.out.println(it.previous()); // 3  2  1
        }

        it = list.listIterator(1);
        it.next();// 要先next 才能设置
        it.set(5);
        System.out.println(list); // [1, 5, 3]
    }
}
