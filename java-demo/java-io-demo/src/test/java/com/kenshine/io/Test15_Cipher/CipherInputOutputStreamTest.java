package com.kenshine.io.Test15_Cipher;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 11:23
 * @description：加密/解密流测试
 * @modified By：
 * @version: $
 *
 * 使用CipherInputStream和CipherOutputStream对文件进行加密和解密
 * 需要在构造时传入一个Cipher
 *
 * 在加解密操作时,密文总是8的倍数,比如明文有51个字节，加密后就会有56个字节，des会自动加上其它字符(空格）来补上，所以加密解密前内容可能有些不一样，需要注意
 */
public class CipherInputOutputStreamTest {
    // 加密类型，支持这三种DESede,Blowfish,AES
    private static final String ENCRYPT_TYPE = "AES";
    // 加密秘钥，长度为24字节 必须为8的倍数
    private static final String ENCRYPT_KEY = "mQbJILokBccRHUkS+XBk7A==";

    /***
     * 测试加密解密
     */
    @Test
    public void test(){
        // 加密 源文件
        encryptFile("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test13\\myfigs.zip", "D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test15\\cipher.zip");
        // 解密
        decryptFile("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test15\\cipher.zip", "D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test15\\unCipher.zip");
    }

    /**
     * 加密文件
     * @param srcFileName  要加密的文件
     * @param destFileName 加密后存放的文件名
     */
    public boolean encryptFile(String srcFileName, String destFileName) {
        FileInputStream is = null;
        FileOutputStream out = null;
        CipherInputStream cis = null;
        try {
            is = new FileInputStream(srcFileName);
            out = new FileOutputStream(destFileName);
            SecretKey deskey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_TYPE);
            Cipher cipher = Cipher.getInstance(ENCRYPT_TYPE);
            cipher.init(Cipher.ENCRYPT_MODE, deskey);
            // 创建加密流
            cis = new CipherInputStream(is, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
            System.out.println("文件" + srcFileName + "加密完成，加密后的文件是:" + destFileName);
            return true;
        } catch (Exception e) {
            System.out.println("加密文件" + srcFileName + "出现异常");
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cis != null) {cis.close();}
            } catch (IOException e) {}
            try {
                if (is != null) {is.close();}
            } catch (IOException e) {}
            try {
                if (out != null) {out.close();}
            } catch (IOException e) {}
        }
    }

    /**
     * 解密文件
     * @param srcFileName  要解密的文件
     * @param destFileName 解密后存放的文件名
     */
    public boolean decryptFile(String srcFileName, String destFileName) {
        FileInputStream is = null;
        FileOutputStream out = null;
        CipherOutputStream cos = null;
        try {
            is = new FileInputStream(srcFileName);
            out = new FileOutputStream(destFileName);
            SecretKey deskey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_TYPE);
            Cipher cipher = Cipher.getInstance(ENCRYPT_TYPE);
            cipher.init(Cipher.DECRYPT_MODE, deskey);
            // 创建解密流
            cos = new CipherOutputStream(out, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = is.read(buffer)) > 0) {
                cos.write(buffer, 0, r);
            }
            System.out.println("文件" + srcFileName + "解密完成，解密后的文件是:" + destFileName);
            return true;
        } catch (Exception e) {
            System.out.println("解密文件" + srcFileName + "出现异常");
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cos != null) {cos.close();}
            } catch (IOException e) {}
            try {
                if (is != null) {is.close();}
            } catch (IOException e) {}
            try {
                if (out != null) {out.close();}
            } catch (IOException e) {}
        }
    }


}
