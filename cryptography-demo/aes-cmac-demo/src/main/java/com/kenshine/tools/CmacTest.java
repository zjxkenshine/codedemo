package com.kenshine.tools;

import java.util.Arrays;

/**
 * AES128-CMAC测试
 * @author Kenshine
 */
public class CmacTest {
    public static void main(String[] args) {
        byte[] key="DFGSAGAGEDAEGEDD".getBytes();
        System.out.println(Arrays.toString(AESCMACUtil.Aes_Cmac01(key, "66666".getBytes())));
        System.out.println(Arrays.toString(AESCMACUtil.Aes_Cmac02(null,key, "66666".getBytes())));
    }

}
