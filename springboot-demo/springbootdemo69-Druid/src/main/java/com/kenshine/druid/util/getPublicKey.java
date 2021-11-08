package com.kenshine.druid.util;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 16:38
 * @description：获取publicKey
 * @modified By：
 * @version: $
 */
public class getPublicKey {

    public static void main(String[] args) {
        try {
            String password = "zjx123456";
            String[] arr = ConfigTools.genKeyPair(512);

            // System.out.println("privateKey:" + arr[0]);
            System.out.println("publicKey:" + arr[1]);
            System.out.println("password:" + ConfigTools.encrypt(arr[0], password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
