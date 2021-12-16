package com.kenshine.bouncycastle.demo01;

import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 22:59
 * @description：
 * @modified By：
 * @version: $
 */
public class test02 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {

        Security.addProvider(new BouncyCastlePQCProvider());
        //此类为加密和解密提供密码功能。它构成了 Java Cryptographic Extension (JCE) 框架的核心
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"), "AES"));
        //加密
        System.out.println(new String(cipher.doFinal("QWEASDZS".getBytes("UTF-8"))));
    }
}
