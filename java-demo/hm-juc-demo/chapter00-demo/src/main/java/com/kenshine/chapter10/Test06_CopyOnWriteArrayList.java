package com.kenshine.chapter10;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 19:42
 * @description： CopyOnWriteArrayList 使用示例
 * @modified By：
 * @version: $
 */
public class Test06_CopyOnWriteArrayList {
    public static void main(String[] args) {
        /**
         * 构造方法摘要
         * CopyOnWriteArrayList()：
         *           创建一个空列表。
         * CopyOnWriteArrayList(Collection<? extends E> c)：
         *           创建一个按 collection 的迭代器返回元素的顺序包含指定 collection 元素的列表。
         * CopyOnWriteArrayList(E[] toCopyIn)：
         *           创建一个保存给定数组的副本的列表。
         */

        /**
         * 1、add(E e) :将指定元素添加到此列表的尾部,返回值为boolean。
         *
         * 2、iterator() :返回以恰当顺序在此列表元素上进行迭代的迭代器,返回值为Iterator<E>。
         */
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Boolean addBoolean = copyOnWriteArrayList.add(1);
        System.out.println("是否添加到此列表的尾部?" + addBoolean);
        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator的结果: " + iterator.next());
        }

        /**
         * 3、add(int index, E element) :在此列表的指定位置上插入指定元素。
         */
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList1 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList1.add(1);
        copyOnWriteArrayList1.add(2);
        copyOnWriteArrayList1.add(2,5);
//        copyOnWriteArrayList1.add(4,6);
        System.out.println("index = 0 的值为：" + copyOnWriteArrayList1.get(0));
        System.out.println("index = 1 的值为：" + copyOnWriteArrayList1.get(1));
        System.out.println("index = 2 的值为：" + copyOnWriteArrayList1.get(2));
//        System.out.println("index = 4 的值为：" + copyOnWriteArrayList1.get(4));
        /**
         * 注意：如果使用add(int index, E element),必须保证index的前面的index存在值，不然会报错。
         *      （可以把上两行注释去掉，运行试试结果）
         */

        /**
         * 4.1、indexOf(E e, int index)
         *           返回第一次出现的指定元素在此列表中的索引，从 index 开始向前搜索，如果没有找到该元素，则返回 -1。
         * 4.2、indexOf(Object o)
         *           返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
         */
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList2.add(1);
        copyOnWriteArrayList2.add(2);
        copyOnWriteArrayList2.add(3);
        Integer indexFirst = copyOnWriteArrayList2.indexOf(2);
        System.out.println("2的index为：" + indexFirst);

        /**
         * 5.1、lastIndexOf(E e, int index)
         *           返回最后一次出现的指定元素在此列表中的索引，从 index 开始向后搜索，如果没有找到该元素，则返回 -1。
         * 5.2、lastIndexOf(Object o)
         *           返回此列表中最后出现的指定元素的索引；如果列表不包含此元素，则返回 -1。
         */
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList3.add(1);
        copyOnWriteArrayList3.add(2);
        copyOnWriteArrayList3.add(3);
        copyOnWriteArrayList3.add(3);
        copyOnWriteArrayList3.add(4);
        Integer lastIndexOf = copyOnWriteArrayList3.lastIndexOf(3);
        System.out.println("列表中最后出现的指定元素的索引: " + lastIndexOf);

        /**
         * 6、remove(int index) ：移除此列表指定位置上的元素,并且此下标后面的值会进一位，
         *                      即index为1的值被remove掉，index为2的值就变为index为1的值。
         */
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList4 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList4.add(5);
        copyOnWriteArrayList4.add(6);
        copyOnWriteArrayList4.add(7);
        copyOnWriteArrayList4.add(8);
        Integer removeResult = copyOnWriteArrayList4.remove(1);
        System.out.println("copyOnWriteArrayList4索引为1的值：" + removeResult);
        System.out.println("copyOnWriteArrayList4中是否还存在索引为1的值：" + copyOnWriteArrayList4.get(1));


        /**
         * 7、remove(Object o) ：从此列表移除第一次出现的指定元素（如果存在）。
         */
        CopyOnWriteArrayList<String> copyOnWriteArrayList5 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList5.add("5");
        copyOnWriteArrayList5.add("6");
        copyOnWriteArrayList5.add("6");
        copyOnWriteArrayList5.add("7");
        copyOnWriteArrayList5.add("7");
        System.out.println("没被remove前的size: " + copyOnWriteArrayList5.size());
        Boolean removeBoolean = copyOnWriteArrayList5.remove("7");
        System.out.println("copyOnWriteArrayList5是否移除7成功？" + removeBoolean);
        System.out.println("index为3的值为：" + copyOnWriteArrayList5.get(3));
        System.out.println("被remove后的size: " + copyOnWriteArrayList5.size());

        /**
         * 8、set(int index, E element) ：用指定的元素替代此列表指定位置上的元素。
         */
        CopyOnWriteArrayList<String> copyOnWriteArrayList6 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList6.add("1");
        copyOnWriteArrayList6.add("2");
        copyOnWriteArrayList6.add("3");
        copyOnWriteArrayList6.add("4");
        copyOnWriteArrayList6.add("5");
        System.out.println("没使用set()方法前，index = 1 的值为：" + copyOnWriteArrayList6.get(1));
        copyOnWriteArrayList6.set(1,"czd");
        System.out.println("使用set()方法后，index = 1 的值为：" + copyOnWriteArrayList6.get(1));
    }
}
