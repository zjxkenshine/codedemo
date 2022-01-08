package com.kenshine.basic._01_base;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 23:10
 * @description：
 * @modified By：
 * @version: $
 * 效率 StringBuilder>StringBuffer>String
 * StringBuilder类 单线程操作字符串缓冲区，可变长字符串
 * StringBuffer：线程安全的，字符串缓冲区
 */
public class test09_StringBuilderBuffer {
    public static void main(String[] args) {
        //StringBuffer
        long start1 = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i<100000;i++){
            stringBuffer.append("aaa");
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

        //StringBuilder
        long start2 = System.currentTimeMillis();
        StringBuilder stringB = new StringBuilder();
        for (int i = 0;i<100000;i++){
            stringBuffer.append("aaa");
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);

        //String
        long start3 = System.currentTimeMillis();
        String str = new String();
        for (int i = 0;i<100000;i++){
            str = str+"aaa";
        }
        long end3 = System.currentTimeMillis();
        System.out.println(end3-start3);
    }
}
