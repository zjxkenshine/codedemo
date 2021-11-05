package com.kenshine.tools;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;

/**
 * 文件加密测试
 * @author Kenshine
 */
public class CMAC {
    private static final String fileName = "111.pdf";
    private static int BLOCK_LEN;
    private Cipher cipher;
    private byte[] key;
    private byte[] k1;
    private byte[] k2;

    public static void main(String[] args) throws Exception {
        CMAC cmac = new CMAC();
        cmac.init();
        System.out.println(cmac.getMAC(new FileInputStream(fileName)));
    }

    private void init() throws Exception {
        BLOCK_LEN = 16;
        key = getKey("507030965420101114".getBytes());
        cipher = Cipher.getInstance("AES/CBC/noPadding");
        IvParameterSpec iv = new IvParameterSpec(key);
        SecretKeySpec sk = new SecretKeySpec(key, 0, BLOCK_LEN, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, sk, iv);
        byte[] kl = cipher.update(new byte[BLOCK_LEN]);
        k1 = getSubKey(kl);
        k2 = getSubKey(k1);
    }

    /**
     * 得到MAC
     * @param text
     * @return
     * @throws Exception
     */
    private String getMAC(FileInputStream text) throws Exception {
        byte[] cipherText = new byte[BLOCK_LEN];
        byte[] current = new byte[BLOCK_LEN];
        byte[] next = new byte[BLOCK_LEN];
        int currentLen, nextLen;
        currentLen = text.read(current);
        do {
            nextLen = text.read(next);
            if (nextLen != -1) {
                cipherText = cipher.update(xor(current, cipherText));
                current = next;
                currentLen = nextLen;
                next = new byte[BLOCK_LEN];
                nextLen = 0;
            }
        } while (nextLen != -1);
        if (currentLen < BLOCK_LEN) {
            cipherText = cipher.update(xor(xor(padding(current, currentLen), k2), cipherText));
        } else {
            cipherText = cipher.update(xor(xor(padding(current, currentLen), k1), cipherText));
        }
        return hashCode(cipherText);
    }

    /**
     * 将原来的密码截断为128位
     * @param key
     * @return
     */
    private byte[] getKey(byte[] key) {
        byte[] a = new byte[BLOCK_LEN];
        for (int i = 0; i < BLOCK_LEN; i++) {
            a[i] = key[i];
        }
        return a;
    }

    /**
     * 获取子密码
     * @param key
     * @return
     */
    private byte[] getSubKey(byte[] key) {
        byte[] a = new byte[BLOCK_LEN];
        for (int i = 0; i < BLOCK_LEN - 1; i++) {
            if (key[i + 1] < 0) {
                a[i] = (byte) (((key[i] << 1) + 1) & 0xFF);
            } else {
                a[i] = (byte) ((key[i] << 1) & 0xFF);
            }
        }
        a[BLOCK_LEN - 1] = (byte) ((key[BLOCK_LEN - 1] << 1) & 0xFF);
        if (key[0] < 0) {
            a[BLOCK_LEN - 1] = (byte) (a[BLOCK_LEN - 1] ^ 0x87);
        }
        return a;
    }

    /**
     * 异或运算
     * @param a
     * @param b
     * @return
     */
    private byte[] xor(byte[] a, byte[] b) {
        byte[] c = new byte[BLOCK_LEN];
        for (int i = 0; i < BLOCK_LEN; i++) {
            c[i] = (byte) (a[i] ^ b[i]);
        }
        return c;
    }

    /**
     * 位填充
     * @param a
     * @param len
     * @return
     */
    private byte[] padding(byte[] a, int len) {
        byte[] b = new byte[BLOCK_LEN];
        for (int i = 0; i < BLOCK_LEN; i++) {
            if (i < len) {
                b[i] = a[i];
            }
            if (i == len) {
                b[i] = (byte) 0x80;
            }
            if (i > len) {
                b[i] = (byte) 0x00;
            }
        }
        return b;
    }

    /**
     * 得到最后一部分的hashCode
     * @param a
     * @return
     */
    private String hashCode(byte[] a) {
        String b = new String();
        for (int i = 0; i < BLOCK_LEN; i++) {
            b = b + Integer.toHexString((a[i] >> 4) & 0x0F);
            b = b + Integer.toHexString(a[i] & 0x0F);
        }
        return b;
    }
}
