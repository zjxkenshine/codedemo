package com.kenshine.onenio;

import one.nio.util.*;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname Test15_Util
 * @Description util测试
 * @Date 2023-11-15 17:39
 * @modified By：
 * @version: 1.0$
 *
 * 其他
 * DigestStream
 * MethodHandlesReflection
 *
 */
public class Test15_Util {

    /**
     * URLEncoder
     */
    @Test
    public void testEncode() {
        final String[] pairs = {
                "SimpleString1_SimpleString2_SimpleString3", "SimpleString1_SimpleString2_SimpleString3",
                "param1=value1&param2=value", "param1%3Dvalue1%26param2%3Dvalue",
                "Просто-Строка", "%D0%9F%D1%80%D0%BE%D1%81%D1%82%D0%BE-%D0%A1%D1%82%D1%80%D0%BE%D0%BA%D0%B0",
                "one.nio.mem:type=MallocMT,*#FreeMemory", "one.nio.mem%3Atype%3DMallocMT%2C*%23FreeMemory"
        };

        for (int i = 0; i < pairs.length; i += 2) {
            assertEquals(pairs[i], URLEncoder.decode(pairs[i + 1]));
            assertEquals(pairs[i + 1], URLEncoder.encode(pairs[i]));
        }
        assertEquals(" A B ", URLEncoder.decode("+A+B+"));
    }

    /**
     * HEX 十六进制
     */
    @Test
    public void testBytes() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int length = random.nextInt(256) * 2;
            char[] digits = new char[length];
            for (int j = 0; j < digits.length; j++) {
                digits[j] = Hex.SMALL[random.nextInt(16)];
            }

            String s = new String(digits);
            assertEquals(s, Hex.toHex(Hex.parseBytes(s)));
        }
    }
    /**
     * HEX 十六进制
     */
    @Test
    public void testNumbers() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int n = random.nextInt();
            String ns = Hex.toHex(n);
            assertEquals(8, ns.length(), 8);
            assertEquals(n, Hex.parseInt(ns));

            long m = random.nextLong();
            String ms = Hex.toHex(m);
            assertEquals(16, ms.length(), 16);
            assertEquals(m, Hex.parseLong(ms), m);
        }
    }

    /**
     * ByteArrayBuilder
     */
    @Test
    public void appendInt() {
        check(0);
        check(1);
        check(-1);
        check(64);
        check(100);
        check(999999);
        check(-1000000);
        check(Integer.MAX_VALUE);
        check(Integer.MIN_VALUE);
    }

    /**
     * Dataformat
     */
    @Test
    public void testPatterns() {
        testPattern("yyyy-MM-dd HH:mm:ss.SSS");
        testPattern("EEE, dd MMM yyyy HH:mm:ssZZZ");
        testPattern("EEE, dd MMM yyyy HH:mm:ssZ", "GMT");
        testPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'", "GMT");
        testPattern("dd.MM.yy", "PST");
        testPattern("HH:mm");
        testPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", "UTC");
    }

    private void testPattern(String pattern) {
        testPattern(pattern, DateFormat.ofPattern(pattern), TimeZone.getDefault());
    }

    private void testPattern(String pattern, String timeZone) {
        testPattern(pattern, DateFormat.ofPattern(pattern, timeZone), TimeZone.getTimeZone(timeZone));
    }

    private void testPattern(String pattern, DateFormat format, TimeZone timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        sdf.setTimeZone(timeZone);

        long date = Dates.JAN_1_1600 + Dates.MS_IN_DAY;
        for (int i = 0; i < 200_000; i++) {
            String orig = sdf.format(new Date(date));
            String my = format.format(date);
            Assert.assertEquals(orig, my);
            date += ThreadLocalRandom.current().nextLong(Dates.MS_IN_DAY * 2);
        }
    }

    private void check(int n) {
        byte[] expected = Integer.toString(n).getBytes(StandardCharsets.UTF_8);
        byte[] actual = new ByteArrayBuilder().append(n).toBytes();
        Assert.assertArrayEquals(expected, actual);
    }
}
