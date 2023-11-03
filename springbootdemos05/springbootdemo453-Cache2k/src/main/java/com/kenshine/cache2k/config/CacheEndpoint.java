package com.kenshine.cache2k.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author by kenshine
 * @Classname CacheEndpoint
 * @Description
 * @Date 2023-11-03 12:29
 * @modified By：
 * @version: 1.0$
 */
@Component
@Endpoint(id = "cache")
public class CacheEndpoint{
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheEndpoint.class);

    private final CacheManager cacheManager;

    @Value("${cache.name:default}")
    private String cacheName;

    @Value("${cache.example.keys}")
    private String[] keys;

    @Value("${cache.example.values}")
    private String[] values;

    @Autowired
    public CacheEndpoint(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostConstruct
    public void init() {
        LOGGER.info("Populating cache with values");

        Cache cache = cacheManager.getCache(cacheName);
        for (int i = 0; i < keys.length; i++) {
            cache.putIfAbsent(keys[i], values[i]);
        }
    }

    @ReadOperation
    public String invoke() {
        StringBuilder stringBuilder = new StringBuilder();

        Cache cache = cacheManager.getCache(cacheName);
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
