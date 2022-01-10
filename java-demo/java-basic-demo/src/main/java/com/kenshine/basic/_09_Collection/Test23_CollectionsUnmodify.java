package com.kenshine.basic._09_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 23:27
 * @description：
 * @modified By：
 * @version: $
 */
public class Test23_CollectionsUnmodify {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        List<String> list2 = Collections.unmodifiableList(list);
        System.out.println(list2);
        // 会抛出java.lang.UnsupportedOperationException 错误，该集合无法操作
        list2.add("d");
        System.out.println(list2);
    }
}
