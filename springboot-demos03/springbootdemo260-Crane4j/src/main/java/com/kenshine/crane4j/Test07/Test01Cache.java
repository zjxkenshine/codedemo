package com.kenshine.crane4j.Test07;

import cn.crane4j.core.cache.Cache;
import cn.crane4j.core.cache.CacheManager;
import cn.crane4j.core.cache.ConcurrentMapCacheManager;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by kenshine
 * @Classname Test01Cache
 * @Description 缓存 CacheManager
 * @Date 2023-10-16 17:02
 * @modified By：
 * @version: 1.0$
 */
public class Test01Cache {

    public void test(){
        // 创建cacheManager
        CacheManager cacheManager = new ConcurrentMapCacheManager(()->new ConcurrentHashMap<>(16));
        // 获取名为 "foo" 的缓存对象
        Cache<String> cache = cacheManager.getCache("foo");

        // 使用缓存对象进行读写操作
        cache.get("cacheKey");
        cache.put("cacheKey", "cacheValue");

        // 销毁名为 "foo" 的缓存对象
        cacheManager.removeCache("foo");
    }


}
