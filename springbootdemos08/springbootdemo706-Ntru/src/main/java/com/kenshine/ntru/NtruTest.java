package com.kenshine.ntru;

import net.sf.ntru.encrypt.EncryptionKeyPair;
import net.sf.ntru.encrypt.EncryptionParameters;
import net.sf.ntru.encrypt.NtruEncrypt;
import net.sf.ntru.sign.NtruSign;
import net.sf.ntru.sign.SignatureKeyPair;
import net.sf.ntru.sign.SignatureParameters;

/**
 * @author by kenshine
 * @Classname NtruTest
 * @Description ntru加密与签名简单使用
 * @Date 2024-02-24 13:06
 * @modified By：
 * @version: 1.0$
 */
public class NtruTest {
    public static void main(String[] args) {
        encrypt();
        System.out.println();
        sign();
    }

    private static void encrypt() {
        System.out.println("NTRU encryption");
        // 使用标准参数集创建NtruEncrypt实例
        NtruEncrypt ntru = new NtruEncrypt(EncryptionParameters.APR2011_439_FAST);
        // 创建加密密钥对
        EncryptionKeyPair kp = ntru.generateKeyPair();
        String msg = "The quick brown fox";
        System.out.println("  Before encryption: " + msg);

        // 使用上面创建的公钥加密消息
        byte[] enc = ntru.encrypt(msg.getBytes(), kp.getPublic());
        System.out.println(" After encryption: " + new String(enc));
        // 使用上面创建的私钥解密消息
        byte[] dec = ntru.decrypt(enc, kp);
        // 打印解密信息
        System.out.println("  After decryption:  " + new String(dec));
    }

    private static void sign() {
        System.out.println("NTRU signature");
        // 使用测试参数集创建NtruSign的实例
        NtruSign ntru = new NtruSign(SignatureParameters.TEST157);
        // 创建签名密钥对
        SignatureKeyPair kp = ntru.generateKeyPair();
        String msg = "The quick brown fox";
        System.out.println("  Message: " + msg);

        // 使用上面创建的私钥对消息进行签名
        byte[] sig = ntru.sign(msg.getBytes(), kp);
        // 使用上面创建的公钥验证签名
        boolean valid = ntru.verify(msg.getBytes(), sig, kp.getPublic());
        System.out.println("  Signature valid? " + valid);
    }
}
