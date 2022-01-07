package com.kenshine.io.Test17_StringReader;

import java.io.StringBufferInputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 20:55
 * @description：
 * @modified By：
 * @version: $
 *
 * 只使用每个字符中的低8位
 */
public class StringBufferInputStreamTest {

    public static void main(String[] args) {
        //已过时，建议使用StringReader
        StringBufferInputStream str = new StringBufferInputStream("kenshine");
    }

}
