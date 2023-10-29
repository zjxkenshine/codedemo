package com.kenshine.chardet4j;

import com.sigpwned.chardet4j.Chardet;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/29 14:19
 * @description：测试
 * @modified By：
 * @version: $
 */
public class ChardetTest {

    @Test
    public void test01() {
        Charset charset = Chardet.detectCharset("hello".getBytes(StandardCharsets.UTF_8)).get();
        System.out.println(charset);
    }

    @Test
    public void iso8859Test() {
        Charset charset =
                Chardet.detectCharset("Hello, world!".getBytes(StandardCharsets.ISO_8859_1)).get();
        System.out.println(charset);
    }
}
