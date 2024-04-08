package com.kenshine.crc.utils;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

/**
 * @author kenshine
 * CRC32工具类
 */
public class CRC32Util {
    public static long calculateCRC32(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return crc32.getValue();
    }

    public static long calculateCRC32(String message) {
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        return calculateCRC32(data);
    }

    public static long calculateCRC16(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return crc32.getValue();
    }

    public static long calculateCRC16(String message) {
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        return calculateCRC32(data);
    }

    public static void main(String[] args) {
        String message = "Hello, world!";
        long crc32Value = calculateCRC32(message);
        System.out.println("CRC-32 value: " + crc32Value);
    }
}