package com.kenshine.jasypt.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 23:22
 * @description：Jasypt加密工具类
 * @modified By：
 * @version: $
 */
public class JasyptUtils {
    private JasyptUtils() {}

    private static String DEFAULT_KEY = "iscas";

    public static String encrypt(String content, String key) {
        StandardPBEStringEncryptor se = new StandardPBEStringEncryptor();
        se.setPassword(key);
        return se.encrypt(content);
    }

    public static String encrypt(String content) {
        return encrypt(content, DEFAULT_KEY);
    }

    public static String decrypt(String content, String key) {
        StandardPBEStringEncryptor se = new StandardPBEStringEncryptor();
        se.setPassword(key);
        return se.decrypt(content);
    }

    public static String decrypt(String content) {
        return decrypt(content, DEFAULT_KEY);
    }

    public static void main(String[] args) {
        //加密数据库密码，得到结果配置到配置文件
        System.out.println(encrypt("zjx123456"));
    }

}
