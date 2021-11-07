package com.kenshine.flowable.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: kenshine
 * @Date: 2018/11/7 16:34
 */
public class MD5Util {

//    private final static String SALT = "0fdfa5e5a88bebae640L&d88e7c84708+==";

    /**
     * 密码加密，加盐双层加密
     *
     * @param source
     * @return
     */
    public static String encrypt(String source, String salt) {
        try {
            return encodeMd5((encodeMd5(source.getBytes(StandardCharsets.UTF_8)) + salt).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 密码加密，直接单层加密
     *
     * @param source
     * @return
     */
    public static String encrypt(String source) {
        try {
            return encodeMd5(source.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String encodeMd5(byte[] source) {
        try {
            return encodeHex(MessageDigest.getInstance("MD5").digest(source));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private static String encodeHex(byte[] bytes) {
        StringBuffer buffer = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10)
                buffer.append("0");
            buffer.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buffer.toString();
    }

    /**
     * 密码验证
     *
     * @return
     */
    public static void main(String[] args) {
        // 随机盐值
        String salt = Salt.salt();
        System.out.println(salt);
        // 密码加密
        String code = MD5Util.encrypt("123456", "");
        System.out.println(code);
    }

}


