package com.kenshine.directmemory;

import org.apache.directmemory.DirectMemory;
import org.apache.directmemory.cache.CacheService;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname DirectMemoryTest
 * @Description 使用测试
 * @Date 2024-01-31 8:43
 * @modified By：
 * @version: 1.0$
 */
public class DirectMemoryTest {
    /**
     * 简单使用
     */
    @Test
    public void test01() throws IOException {
        CacheService<Object, Object> cacheService = new DirectMemory<>()
                // 缓冲区大小
                .setNumberOfBuffers( 10 )
                .setSize( 1000 )
                .setInitialCapacity( 100000 )
                .setConcurrencyLevel( 4 )
                .newCacheService();
        cacheService.put("name","kenshine");
        cacheService.put("name1","lin",1000);
        // 恢复
        String name = (String) cacheService.retrieve("name");
        System.out.println(name);
        System.out.println(cacheService.getPointer("name1").getExpiresIn());
        cacheService.clear();
        cacheService.close();
    }

    /**
     *
     */
}
