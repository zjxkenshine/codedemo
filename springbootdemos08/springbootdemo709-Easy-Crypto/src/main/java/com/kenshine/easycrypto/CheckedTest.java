package com.kenshine.easycrypto;

import cloud.tianai.crypto.check.impl.CRC64Checksum;
import cloud.tianai.crypto.check.impl.Md5Checksum;
import cloud.tianai.crypto.check.impl.MultiPartChecksum;
import cloud.tianai.crypto.check.impl.Sha256Checksum;
import cloud.tianai.crypto.stream.EnhanceCheckedInputStream;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author by kenshine
 * @Classname CheckedTest
 * @Description 签名与验签测试
 * @Date 2024-02-28 8:29
 * @modified By：
 * @version: 1.0$
 */
public class CheckedTest {
    /**
     * 获取一个文件的 md5
     */
    @Test
    public void getFileMd5() throws IOException {
        // 源文件
        FileInputStream source = new FileInputStream("pdf\\Test.pdf");
        Md5Checksum md5Checksum = new Md5Checksum();
        EnhanceCheckedInputStream checkedInputStream = new EnhanceCheckedInputStream(source, md5Checksum);
        readAll(checkedInputStream);
        byte[] md5 = md5Checksum.getCheckValue();
        System.out.println("md5:" + Hex.toHexString(md5));
    }

    /**
     * 获取一个文件的 crc64
     */
    @Test
    public void getFileCrc64() throws IOException {
        // 源文件
        FileInputStream source = new FileInputStream("pdf\\Test.pdf");
        CRC64Checksum crc64Checksum = new CRC64Checksum();
        EnhanceCheckedInputStream checkedInputStream = new EnhanceCheckedInputStream(source, crc64Checksum);
        readAll(checkedInputStream);
        Long crc64 = crc64Checksum.getCheckValue();
        System.out.println("crc64:" + crc64);
    }


    /**
     * 同时获取一个文件的  md5、crc64、sha256
     */
    @Test
    public void getFileChecksum() throws IOException {
        Md5Checksum md5Checksum = new Md5Checksum();
        CRC64Checksum crc64Checksum = new CRC64Checksum();
        Sha256Checksum sha256Checksum = new Sha256Checksum();
        MultiPartChecksum multiPartChecksum = new MultiPartChecksum(md5Checksum, crc64Checksum, sha256Checksum);

        FileInputStream source = new FileInputStream("pdf\\Test.pdf");
        EnhanceCheckedInputStream checkedInputStream = new EnhanceCheckedInputStream(source, multiPartChecksum);
        readAll(checkedInputStream);

        System.out.println("md5:" + Hex.toHexString(md5Checksum.getCheckValue()));
        System.out.println("crc64:" + crc64Checksum.getCheckValue());
        System.out.println("sha256:" + Hex.toHexString(sha256Checksum.getCheckValue()));

    }


    public void readAll(InputStream input) throws IOException {
        byte[] buffer = new byte[4096];
        while (-1 != input.read(buffer)) {
        }
    }
}
