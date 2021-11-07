package com.kenshine.flowable.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * @Author: linqj
 * @Date: 2019/4/17 11:04
 */
@DependsOn({"redisCacheManager", "ehcacheCacheManager"})
public class CacheConfig {

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Bean("cacheManager")
    @Primary
    public CacheManager compositeCacheManager() {
        CompositeCacheManager compositeCacheManager = new CompositeCacheManager(redisCacheManager);
        return compositeCacheManager;
    }
}
