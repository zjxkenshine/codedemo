package com.kenshine.okio.demo;

import okio.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 8:54
 * @description：
 * @modified By：
 * @version: $
 *
 * 从官网Recipes搬过来的demo
 */
public class OkioDemo {

    /**
     * 逐行读取文本文件
     */
    public static void readLines(Path path) throws IOException {
        try (Source fileSource = FileSystem.SYSTEM.source(path);
             BufferedSource bufferedFileSource = Okio.buffer(fileSource)) {

            while (true) {
                String line = bufferedFileSource.readUtf8Line();
                if (line == null) {
                    break;
                }

                if (line.contains("kenshine")) {
                    System.out.println(line);
                }
            }

        }
    }

    /**
     * 写一个文本文件
     */
    public static void writeEnv(Path path) throws IOException {
        try (Sink fileSink = FileSystem.SYSTEM.sink(path);
             BufferedSink bufferedSink = Okio.buffer(fileSink)) {

            for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
                bufferedSink.writeUtf8(entry.getKey());
                bufferedSink.writeUtf8("=");
                bufferedSink.writeUtf8(entry.getValue());
                bufferedSink.writeUtf8("\n");
            }

        }
    }

    /**
     * UTF-8
     * BufferedSource.readUtf8CodePoint() 读取单个可变长度代码点
     * BufferedSink.writeUtf8CodePoint()  写一个代码点
     * 代码点：码点是指与一个编码表中的某个字符对应的代码值
     * 代码单元：代码单元是指一种转换格式（UTF）中最小的一个分隔，只会包含整数个代码单元
     *      - UTF-8 的 8 指的就是最小为8bit一个单元，也即一字节为一个单元
     *      - UTF-16 的 16 指的就是最小为16bit一个单元，也即两字节为一个单元
     *      - UTF-32 以 32bit 一个单元
     */
    public static void dumpStringData(String s) throws IOException {
        System.out.println("                       " + s);
        System.out.println("        String.length: " + s.length());
        System.out.println("String.codePointCount: " + s.codePointCount(0, s.length()));
        System.out.println("            Utf8.size: " + Utf8.size(s));
        // hex:十六进制
        System.out.println("          UTF-8 bytes: " + ByteString.encodeUtf8(s).hex());
        System.out.println();
    }


    /**
     * 获取 ByteString
     * 序列化
     */
    private static ByteString serialize(Object o) throws IOException {
        // 可以替换ByteArrayOutputStream
        Buffer buffer = new Buffer();
        try (ObjectOutputStream objectOut = new ObjectOutputStream(buffer.outputStream())) {
            objectOut.writeObject(o);
        }
        return buffer.readByteString();
    }

    /**
     * 反序列化
     */
    private static Object deserialize(ByteString byteString) throws IOException, ClassNotFoundException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        try (ObjectInputStream objectIn = new ObjectInputStream(buffer.inputStream())) {
            return objectIn.readObject();
        }
    }

    /**
     * 编写一个二进制文件
     * BMP 文件格式
     *  - 每个字段的宽度
     *  - 每个字段的字节序
     *  - 签名与未签名
     *
     *  Bitmap 为安卓开发的位图
     *  https://square.github.io/okio/recipes/#write-a-binary-file-javakotlin
     */


    /**
     * 在套接字上通信
     * Socket fromSocket = ...
     * BufferedSource fromSource = Okio.buffer(Okio.source(fromSocket));
     * BufferedSink fromSink = Okio.buffer(Okio.sink(fromSocket));
     */

    /**
     * 获取ByteString
     */
    public static ByteString readByteString(Path path) throws IOException {
        try (Source fileSource = FileSystem.SYSTEM.source(path);
            BufferedSource bufferedFileSource = Okio.buffer(fileSource)) {
            return bufferedFileSource.readByteString();
        }
    }

    /**
     * 获取buffer
     */
    public static Buffer readBuffer(Path path) throws IOException {
        try (Source fileSource = FileSystem.SYSTEM.source(path);
             BufferedSource bufferedFileSource = Okio.buffer(fileSource)) {
            return bufferedFileSource.getBuffer();
        }
    }


    /**
     * 哈希，Okio支持的hash函数
     * MD5
     * SHA-1
     * SHA-256
     * SHA-512
     */
    public static void testHash() throws IOException {
        //从ByteString中获取
        ByteString byteString = readByteString(Path.get("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo186-Okio\\src\\main\\resources\\txt\\test.md"));
        System.out.println("   md5: " + byteString.md5().hex());
        System.out.println("  sha1: " + byteString.sha1().hex());
        System.out.println("sha256: " + byteString.sha256().hex());
        System.out.println("sha512: " + byteString.sha512().hex());

        //从Buffer中获取
        Buffer buffer = readBuffer(Path.get("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo186-Okio\\src\\main\\resources\\txt\\test.md"));
        System.out.println("   md5: " + buffer.md5().hex());
        System.out.println("  sha1: " + buffer.sha1().hex());
        System.out.println("sha256: " + buffer.sha256().hex());
        System.out.println("sha512: " + buffer.sha512().hex());
    }

    /**
     * 加密
     */
    void encryptAes(ByteString bytes, Path path, byte[] key, byte[] iv) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        try (BufferedSink sink = Okio.buffer(
                Okio.cipherSink(FileSystem.SYSTEM.sink(path), cipher))) {
            sink.write(bytes);
        }
    }

    /**
     * 解密
     */
    ByteString decryptAesToByteString(Path path, byte[] key, byte[] iv) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        try (BufferedSource source = Okio.buffer(
                Okio.cipherSource(FileSystem.SYSTEM.source(path), cipher))) {
            return source.readByteString();
        }
    }


    /**
     * 测试 golden value hash
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建一个点
        Point point = new Point(8, 15);
        //获取 ByteString
        ByteString pointBytes = serialize(point);
        //打印Base64值
        System.out.println(pointBytes.base64());

        ByteString goldenBytes = ByteString.decodeBase64("rO0ABXNyAA5qYXZhLmF3dC5Qb2ludLbEinI0fsgmAgACSQABeEkAAXl4cAAAAAgAAAAP");
        Point decoded = (Point) deserialize(goldenBytes);
        System.out.println(decoded.equals(point));

        //测试hash
        testHash();
    }





}
