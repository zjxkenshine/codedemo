package com.kenshine.base64.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.InputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/27 23:08
 * @description：
 * @modified By：
 * @version: $
 */
public class Base64Util {
    /**
     * 解密
     *
     * @param is
     * @param charset
     * @return
     * @throws Exception
     */
    public static String decode(InputStream is, String charset) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(is);
        return new String(buffer, charset);
    }

    /**
     * 解密
     *
     * @param content
     * @param charset
     * @return
     * @throws Exception
     */
    public static String decode(String content, String charset) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(content);
        return new String(buffer, charset);
    }

    /**
     * 加密
     *
     * @param b
     * @return
     * @throws Exception
     */
    public static String encode(byte[] b) throws Exception {
        return new BASE64Encoder().encode(b);
    }

    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String encode(String content) throws Exception {
        return encode(content.getBytes());
    }

    /**
     * 加密
     *
     * @param content
     * @param charset
     * @return
     * @throws Exception
     */
    public static String encode(String content, String charset) throws Exception {
        return encode(content.getBytes(charset));
    }

    private Base64Util() {
    }
}
