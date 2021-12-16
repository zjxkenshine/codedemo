package com.kenshine.bouncycastle.demo01;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 22:57
 * @description：
 * @modified By：
 * @version: $
 */
public class test01 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        // 注册BouncyCastle:
        Security.addProvider(new BouncyCastleProvider());

        // 按名称正常调用:
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        md.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
