package com.kenshine.sm2;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECPoint;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SM2Utils{
 
    public static final String PUBLICKEY = "public_key";
    public static final String PRIVATEKEY = "private_key";
 
    // 生成随机秘钥对
    public static Map<String, String> generateKeyPair() {
        SM2 sm2 = SM2.Instance();
        AsymmetricCipherKeyPair key = null;
        while (true) {
            key = sm2.ecc_key_pair_generator.generateKeyPair();
            if (((ECPrivateKeyParameters) key.getPrivate()).getD().toByteArray().length == 32) {
                break;
            }
        }
        ECPrivateKeyParameters ecpriv = (ECPrivateKeyParameters) key.getPrivate();
        ECPublicKeyParameters ecpub = (ECPublicKeyParameters) key.getPublic();
        BigInteger privateKey = ecpriv.getD();
        ECPoint publicKey = ecpub.getQ();
        String pubk = Util.byteToHex(publicKey.getEncoded());
        String prik = Util.byteToHex(privateKey.toByteArray());
        Map<String, String> result = new HashMap<>();
        result.put(PUBLICKEY, pubk);
        result.put(PRIVATEKEY, prik);
        return result;
    }

    // 数据加密
    public static String encrypt(byte[] publicKey, byte[] data) throws IOException {
        if (publicKey == null || publicKey.length == 0) {
            return null;
        }
        if (data == null || data.length == 0) {
            return null;
        }
        byte[] source = new byte[data.length];
        System.arraycopy(data, 0, source, 0, data.length);
        Cipher cipher = new Cipher();
        SM2 sm2 = SM2.Instance();
        ECPoint userKey = sm2.ecc_curve.decodePoint(publicKey);
        ECPoint c1 = cipher.Init_enc(sm2, userKey);
        cipher.Encrypt(source);
        byte[] c3 = new byte[32];
        cipher.Dofinal(c3);
        return new StringBuffer(Util.byteToHex(c1.getEncoded())).append(Util.byteToHex(c3)).append(Util.byteToHex(source)).toString();
    }
    // 数据解密
    public static String decrypt(String privateKey, String encryptedData) throws IOException {
        if (privateKey == null || privateKey.equals("")) {
            return null;
        }
        if (encryptedData == null || encryptedData.equals("")) {
            return null;
        }
        byte[] data = Util.hexToByte(encryptedData);
        byte[] privateK = Util.hexToByte(privateKey);
        // 加密字节数组转换为十六进制的字符串 长度变为encryptedData.length * 2
        byte[] c1Bytes = Util.hexToByte(encryptedData.substring(0, 130));
        int c2Len = data.length - 97;
        byte[] c3 = Util.hexToByte(encryptedData.substring(130, 130 + 64));
        byte[] c2 = Util.hexToByte(encryptedData.substring(194, 194 + 2 * c2Len));
 
        SM2 sm2 = SM2.Instance();
        BigInteger userD = new BigInteger(1, privateK);
        // 通过C1实体字节来生成ECPoint
        ECPoint c1 = sm2.ecc_curve.decodePoint(c1Bytes);
        Cipher cipher = new Cipher();
        cipher.Init_dec(userD, c1);
        cipher.Decrypt(c2);
        cipher.Dofinal(c3);
        // 返回解密结果
        return new String(c2);
    }
 
    public static void main(String[] args) throws Exception {
        //参数
        String str = "{\"test\":\"001\"}";
        System.out.println("参数:" + str);
 
        byte[] sourceData = str.getBytes();
        //获取公私钥
        Map<String, String> keymap = generateKeyPair();
        System.out.println("公钥:" + keymap.get(PUBLICKEY));
        System.out.println("私钥:" + keymap.get(PRIVATEKEY));
        String cipherText = SM2Utils.encrypt(Util.hexToByte(keymap.get(PUBLICKEY)), sourceData);
        System.out.println("加密:"+cipherText);
        String plainTextEncripted = SM2Utils.decrypt(keymap.get(PRIVATEKEY),cipherText);
        System.out.println("解密:"+plainTextEncripted);
    }
 
 
 
 
}