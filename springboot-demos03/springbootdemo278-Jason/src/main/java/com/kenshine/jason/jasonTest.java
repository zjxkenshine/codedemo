package com.kenshine.jason;

import jason.JasonReader;
import lombok.Data;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/19 1:25
 * @description：
 * @modified By：
 * @version: $
 */
public class jasonTest {
    @Data
    public class C { // 测试的类
        public int a;
        public String b;
        public C c;
    }

    // 测试的JSON字符串
    static String str = "{\"b\":\"xyz\", \"a\":123,\"c\":{\"a\":456,\"b\":\"abc\"}}";
    static byte[] bytes = str.getBytes();
    static final int TEST_COUNT = 100;

    /**
     * json解析jason测试
     */
    @Test
    public void test01() throws ReflectiveOperationException {
        long t = System.nanoTime(), v = 0;
        JasonReader jr = new JasonReader();
        for (int i = 0; i < TEST_COUNT; ++i) {
            C c = jr.buf(bytes).parse(C.class);
            v += c.a + c.c.a;
            System.out.println(c);
        }
        System.out.println("   Jason: " + v + ", " + (System.nanoTime() - t) / 1_000_000 + "ms");
    }
}
