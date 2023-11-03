package com.kenshine.ohc;

import com.kenshine.ohc.serializer.StringSerializer;
import org.caffinitas.ohc.Eviction;
import org.caffinitas.ohc.OHCache;
import org.caffinitas.ohc.OHCacheBuilder;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname OhcTest
 * @Description 测试
 * @Date 2023-11-03 17:10
 * @modified By：
 * @version: 1.0$
 */
public class OhcTest {

    public static void main(String[] args) throws IOException {
        OHCache<String, String> ohCache = OHCacheBuilder.<String, String>newBuilder()
                .keySerializer(new StringSerializer())
                .valueSerializer(new StringSerializer())
                // LRU算法逐出
                .eviction(Eviction.LRU)
                .build();

        ohCache.put("hello", "world");
        // world
        System.out.println(ohCache.get("hello"));
        ohCache.close();
    }
}
