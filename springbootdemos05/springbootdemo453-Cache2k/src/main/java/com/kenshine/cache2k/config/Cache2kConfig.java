package com.kenshine.cache2k.config;

import org.cache2k.extra.spring.SpringCache2kCacheManager;
import org.cache2k.integration.FunctionalCacheLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname Cache2kConfig
 * @Description 配置Bean
 * @Date 2023-11-03 12:16
 * @modified By：
 * @version: 1.0$
 */
@Configuration
@EnableCaching
public class Cache2kConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfig.class);

    @Value("${cache.name:default}")
    private String cacheName;

    @Value("${cache.expire.at:3}")
    private long cacheExpire;

    @Value("${cache.refresh.name:refresh}")
    private String cacheRefreshName;

    @Value("${cache.refresh.expire.at:3}")
    private long cacheRefreshExpire;

    @Value("${cache.example.keys}")
    private String[] keys;

    @Value("${cache.example.values}")
    private String[] values;

    @Bean
    public CacheManager cacheManager(FunctionalCacheLoader<String, String> cacheRefreshLoader) {
        LOGGER.info("Cache parameters: name: {}, expire at (seconds): {}", cacheName, cacheExpire);
        LOGGER.info("Cache refresh parameters: name: {}, expire at (seconds): {}", cacheRefreshName, cacheRefreshExpire);

        return new SpringCache2kCacheManager()
                .addCaches(
                        cache2kBuilder -> cache2kBuilder
                                .name(cacheName)
                                .entryCapacity(1000)
                                .expireAfterWrite(cacheExpire, TimeUnit.SECONDS),
                        cache2kRefreshBuilder -> cache2kRefreshBuilder
                                .name(cacheRefreshName)
                                .expireAfterWrite(cacheRefreshExpire, TimeUnit.SECONDS)
                                .entryCapacity(1000)
                                .keyType(String.class)
                                .valueType(String.class)
                                .loader(cacheRefreshLoader)
                                .permitNullValues(true)
                );
    }

    @Bean
    public FunctionalCacheLoader<String, String> cacheRefreshLoader() {
        List<String> keysList = Arrays.asList(keys);
        List<String> valuesList = Arrays.asList(values);
        return key -> {
            LOGGER.info("Loading value for key '{}'...", key);
            if (keysList.contains(key)) {
                return valuesList.get(keysList.indexOf(key));
            }
            return null;
        };
    }
}
