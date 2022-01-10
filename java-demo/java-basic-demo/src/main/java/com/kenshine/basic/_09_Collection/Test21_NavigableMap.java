package com.kenshine.basic._09_Collection;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 23:21
 * @description：NavigableMap 指定子Map视图操作
 * @modified By：
 * @version: $
 *
 *  NavigableMap扩展了 SortedMap，具有了针对给定搜索目标返回最接近匹配项的导航方法
 */
public class Test21_NavigableMap {
    public static void main(String[] args) {
        NavigableMap<String, Integer> navigatorTreeMap = new TreeMap<String, Integer>(); // SortedMap接收TreeMap的实例
        // 增加元素
        navigatorTreeMap.put("aa", 11);
        navigatorTreeMap.put("bb", 22);
        navigatorTreeMap.put("cc", 33);
        navigatorTreeMap.put("dd", 44);
        navigatorTreeMap.put("ee", 55);
        navigatorTreeMap.put("ff", 55);
        navigatorTreeMap.put("gg", 55);

        System.out.println(navigatorTreeMap.size());// 7个元素：7
        System.out.println(navigatorTreeMap.ceilingKey("cc"));// 返回大于等于cc的最小键：cc
        System.out.println(navigatorTreeMap.ceilingEntry("c"));//  返回一个键-值映射关系，它与大于等于cc的最小键关联：cc=33
        System.out.println(navigatorTreeMap.descendingMap());// 返回逆序视图:{gg=55, ff=55, ee=55, dd=44, cc=33, bb=22, aa=11}
        System.out.println(navigatorTreeMap.firstKey());// 最小键:aa
        System.out.println(navigatorTreeMap.firstEntry());// 最小键对应的k-v键值对：aa=11

        System.out.println(navigatorTreeMap.floorEntry("c"));// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:bb=22
        System.out.println(navigatorTreeMap.floorKey("cc"));//   返回小于等于cc的最大键:cc
        System.out.println(navigatorTreeMap.headMap("bb"));// 返回此映射的部分视图，其键值严格小于bb:{aa=11}
        System.out.println(navigatorTreeMap.headMap("bb", true));// 同上小于等于（true）:{aa=11, bb=22}
        System.out.println(navigatorTreeMap.higherEntry("c"));// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:cc=33
        System.out.println(navigatorTreeMap.higherKey("cc"));//   返回小于等于cc的最大键:dd
        System.out.println(navigatorTreeMap.lastEntry());// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:gg=55
        System.out.println(navigatorTreeMap.lastKey());//   返回小于等于cc的最大键:gg
        System.out.println(navigatorTreeMap.lowerEntry("c"));// 返回一个键-值映射关系，它与小于等于给定键的最大键关联:bb=22
        System.out.println(navigatorTreeMap.lowerKey("cc"));//    返回严格小于cc的最大键:bb
        System.out.println(navigatorTreeMap.pollFirstEntry());//  移除并返回与此映射中的最小键关联的键-值映射关系:aa=11
        System.out.println(navigatorTreeMap.pollLastEntry());//  移除并返回与此映射中的最大键关联的键-值映射关系:gg=55
        System.out.println(navigatorTreeMap.navigableKeySet());//   返回此映射中所包含键的
        // NavigableSet 视图。:[bb, cc, dd, ee, ff]

        System.out.println(navigatorTreeMap.subMap("aa", true, "dd", true));// 返回部分视图，true表示包括当前元素键值对:{bb=22, cc=33, dd=44}
        System.out.println(navigatorTreeMap.subMap("bb", "dd"));// 返回部分视图包括前面的元素，不包括后面的：{bb=22, cc=33}
        System.out.println(navigatorTreeMap.tailMap("cc"));// 返回元素大于cc的元素映射视图,包括cc：//{cc=33, dd=44, ee=55, ff=55}
        System.out.println(navigatorTreeMap.tailMap("cc", false));// 返回元素大于等于cc的元素映射视图:{dd=44, ee=55, ff=55}
        System.out.println(navigatorTreeMap.descendingMap());// 返回此映射中所包含映射关系的逆序：{ff=55, ee=55, dd=44, cc=33, bb=22}视图。:
        System.out.println(navigatorTreeMap.descendingKeySet());// 返回此映射中所包含键的逆序
        // NavigableSet视图:[ff, ee, dd, cc, bb]
    }
}
