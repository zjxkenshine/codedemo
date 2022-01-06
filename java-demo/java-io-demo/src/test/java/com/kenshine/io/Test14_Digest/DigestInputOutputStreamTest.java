package com.kenshine.io.Test14_Digest;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 11:06
 * @description：摘要流
 * @modified By：
 * @version: $
 * MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值
 *
 * DigestInputStream
 * 使用读取流的方式完成摘要更新，调用on(boolean on)方法开启和关闭摘要功能。如果on(false)，则DigestInputStream就变成了一般的输入流，默认开启
 *  - 如果开启了摘要功能，调用read方法时，将调用MessageDigest 类的update方法更新摘要
 * DigestOutputStream
 * 使用写入流的方式完成摘要更新，调用on(boolean on)方法开启和关闭摘要功能。如果on(false)，则DigestOutputStream就变成了一般的输出流，默认开启
 *  - 如果开启了摘要功能，调用write方法时，将调用MessageDigest 类的update方法更新摘要
 */
public class DigestInputOutputStreamTest {

    @Test
    public void test() throws IOException, NoSuchAlgorithmException {
        byte[] bytes = "测试".getBytes();
        //MD5摘要算法
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);

        MessageDigest messageDigest1 = MessageDigest.getInstance("MD5");
        DigestInputStream digestInputStream = new DigestInputStream(new ByteArrayInputStream(bytes), messageDigest1);
        //读取 会更新内部messageDigest1的摘要  相当于也调用了messageDigest1.update(bytes);
        digestInputStream.read(bytes, 0, bytes.length);
        System.out.println(MessageDigest.isEqual(messageDigest.digest(), digestInputStream.getMessageDigest().digest()));
        //摘要字符串
        System.out.println(messageDigest.digest());
        digestInputStream.close();

        MessageDigest messageDigest2 = MessageDigest.getInstance("MD5");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.out.println(byteArrayOutputStream.toString());
        //输出流 会调用 messageDigest2.update
        DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, messageDigest2);
        digestOutputStream.write(bytes, 0, bytes.length);
        System.out.println(digestOutputStream.getMessageDigest().digest());
        System.out.println(byteArrayOutputStream.toString());
        digestOutputStream.flush();
        digestOutputStream.close();
    }
}
