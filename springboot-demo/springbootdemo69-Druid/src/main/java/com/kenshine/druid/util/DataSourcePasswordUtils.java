package com.kenshine.druid.util;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 16:36
 * @description：加密工具类
 * @modified By：
 * @version: $
 */
public class DataSourcePasswordUtils {

    /**
     * 加密
     * @param cipherText
     * @return
     * @throws Exception
     */
    public static String encrypt(String cipherText) throws Exception {
        String encrypt = ConfigTools.encrypt(cipherText);
        return encrypt;
    }

    /**
     * 解密
     * @param cipherText
     * @return
     * @throws Exception
     */
    public static String decrypt(String cipherText) throws Exception {
        String decrypt = ConfigTools.decrypt(cipherText);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        String password = "zjx123456";
        String encrypt = encrypt(password);
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println(decrypt);

    }

}
