package com.kenshine.cache2k.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * 刷新端点
 */
@Component
@Endpoint(id = "refresh-cache")
public class CacheRefreshEndpoint{
    private final CacheManager cacheManager;

    @Value("${cache.refresh.name:default}")
    private String cacheRefreshName;

    @Value("${cache.example.keys}")
    private String[] keys;

    @Autowired
    public CacheRefreshEndpoint(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @ReadOperation
    public String invoke() {
        StringBuilder stringBuilder = new StringBuilder();
        Cache cache = cacheManager.getCache(cacheRefreshName);
        for (String key : keys) {
            String value = cache.get(key,String.class);
            stringBuilder
                    .append(key)
                    .append(":")
                    .append(value)
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}