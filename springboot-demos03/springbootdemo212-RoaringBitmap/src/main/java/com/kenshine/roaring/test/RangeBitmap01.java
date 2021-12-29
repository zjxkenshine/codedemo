package com.kenshine.roaring.test;

import org.roaringbitmap.RangeBitmap;
import org.roaringbitmap.RoaringBitmap;

import java.sql.SQLOutput;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 22:51
 * @description：RangeBitmap测试1
 * @modified By：
 * @version: $
 */
public class RangeBitmap01 {
    public static void main(String[] args) {
        RangeBitmap.Appender appender = RangeBitmap.appender(1_000_000);
        appender.add(1L);
        appender.add(1L);
        appender.add(100_000L);
        RangeBitmap bitmap = appender.build();
        // {0,1}
        RoaringBitmap lessThan5 = bitmap.lt(5);
        // {0, 1, 2}
        RoaringBitmap greaterThanOrEqualTo1 = bitmap.gte(1);
        // {2}
        RoaringBitmap greaterThan1 = bitmap.gt(1);

        System.out.println(lessThan5);
        System.out.println(greaterThanOrEqualTo1);
        System.out.println(greaterThan1);
    }
}
