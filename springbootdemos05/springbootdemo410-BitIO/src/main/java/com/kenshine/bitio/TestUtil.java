package com.kenshine.bitio;

import im.jeanfrancois.bitio.util.BitIOUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname TestUtil
 * @Description 测试Zigzag编码
 * @Date 2023-10-25 8:36
 * @modified By：
 * @version: 1.0$
 */
public class TestUtil {
    @Test
    public void testZigZag() {
        assertEquals(1, BitIOUtils.encodeAsZigZag(-1));
        assertEquals(2, BitIOUtils.encodeAsZigZag(1));
        assertEquals(3, BitIOUtils.encodeAsZigZag(-2));
        assertEquals(4, BitIOUtils.encodeAsZigZag(2));

        for(int i = -100; i < 100; ++i) {
            assertEquals(i, BitIOUtils.decodeZigZag(BitIOUtils.encodeAsZigZag(i)));
        }
    }
}
