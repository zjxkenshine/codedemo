package com.kenshine.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 19:42
 * @description：Jol分析对象占用
 * @modified By：
 * @version: $
 */
public class TestJOL {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        String str = new String();
        System.out.println(ClassLayout.parseInstance(str).toPrintable());

        // 占用16字节 其中对象头12字节，实例数据int占用4字节
        Integer integer = new Integer(0);
        System.out.println(ClassLayout.parseInstance(integer).toPrintable());

        // 24字节 其中对象头12字节，实例数据long占用8字节，对齐填充4字节（必须是8的整数倍）
        Long aLong = new Long(0L);
        System.out.println(ClassLayout.parseInstance(aLong).toPrintable());

        // 416字节 其中对象头16字节，对齐填充100*4=400字节。
        Object[] objects = new Object[100];
        System.out.println(ClassLayout.parseInstance(objects).toPrintable());

        // 416字节 其中对象头16字节，对齐填充100*4=400字节。
        String[] strs = new String[100];
        System.out.println(ClassLayout.parseInstance(strs).toPrintable());
    }
}
