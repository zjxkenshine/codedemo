package com.kenshine.basic._09_Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/10 23:28
 * @description：检查型视图
 * @modified By：
 * @version: $
 *
 * “ 受査” 视图用来对泛型类型发生问题时提供调试支持
 */
public class Test24_CollectionsChecked {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("12", "23");
        //基于现有集合创建新集合
        List<String> safeList = Collections.checkedList(list, String.class);
        System.out.println(safeList);
        List obj = safeList;
        //检查容器视图受限于虚拟机可运行的运行时检查
        obj.add(new Date());//只有执行到这一步才会抛出java.lang.ClassCastException
    }
}
