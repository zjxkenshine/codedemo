package com.kenshine.jconch;

import com.jconch.cache.ObjectCacheMap;
import org.apache.commons.collections.functors.NOPTransformer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname CacheTest
 * @Description cache包ObjectCacheMap
 * @Date 2023-10-27 10:13
 * @modified By：
 * @version: 1.0$
 */
public class CacheTest {

    /**
     * 重复获取
     */
    @Test
    public void getKeyTwice() {
        final ObjectCacheMap map = new ObjectCacheMap(
                NOPTransformer.getInstance());
        final Object out1 = map.get(new Integer(1));
        final Object out2 = map.get(new Integer(1));
        assertEquals(out1, out2);
    }

    @Test
    public void checkOnEquals() {
        final ObjectCacheMap map1 = new ObjectCacheMap(
                NOPTransformer.getInstance());
        final ObjectCacheMap map2 = new ObjectCacheMap(
                NOPTransformer.getInstance());
        assertTrue(map1.equals(map1));
        assertFalse(map1.equals(null));
        assertTrue(map1.equals(map2));
        assertFalse(map1.equals(new Object()));
    }
}
