package com.kenshine.roaring.test;

import org.roaringbitmap.RangeBitmap;

import java.nio.ByteBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 22:53
 * @description：
 * @modified By：
 * @version: $
 */
public class RangeBitmap02 {
    public static void main(String[] args) {
        RangeBitmap.Appender appender = RangeBitmap.appender(1_000_000);
        appender.add(1L);
        appender.add(1L);
        appender.add(100_000L);
        ByteBuffer buffer = mapBuffer(appender.serializedSizeInBytes());
        appender.serialize(buffer);
        //java.nio.BufferUnderflowException
        RangeBitmap bitmap = RangeBitmap.map(buffer);
        System.out.println(bitmap);
    }

    private static ByteBuffer mapBuffer(int serializedSizeInBytes) {
        return ByteBuffer.allocate(serializedSizeInBytes);
    }
}
