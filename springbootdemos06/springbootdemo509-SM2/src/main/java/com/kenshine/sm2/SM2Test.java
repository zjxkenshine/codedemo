package com.kenshine.sm2;

import cn.xsshome.algorithmNation.util.SM2EnDecryption;
import cn.xsshome.algorithmNation.util.SMCertUtil;
import cn.xsshome.algorithmNation.util.Util;
import com.xiaoleilu.hutool.lang.Base64;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname SM2Test
 * @Description SM2加解密测试
 * @Date 2023-11-28 9:10
 * @modified By：
 * @version: 1.0$
 */
public class SM2Test {

    /**
     * SM2加解密
     */
    @Test
    public void test01() throws IOException {
        String text = "测试";
        byte[] source = text.getBytes();
        String publicKey ="FA05C51AD1162133DFDF862ECA5E4A481B52FB37FF83E53D45FD18BBD6F32668A92C4692EEB305684E3B9D4ACE767F91D5D108234A9F07936020A92210BA9447";
        String result = SM2EnDecryption.encrypt(Util.hexToByte(publicKey), source);
        System.out.println(Base64.encode(result));
        String privatekey = "5EB4DF17021CC719B678D970C620690A11B29C8357D71FA4FF9BF7FB6D89767A";
        byte[] decryptresult = SM2EnDecryption.decrypt(Util.hexToByte(privatekey), Util.hexToByte(result));
        System.out.println(new String(decryptresult));
    }



}
