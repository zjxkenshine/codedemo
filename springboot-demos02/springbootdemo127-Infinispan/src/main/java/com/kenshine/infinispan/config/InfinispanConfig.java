package com.kenshine.infinispan.config;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.spring.embedded.provider.SpringEmbeddedCacheManager;
import org.infinispan.spring.starter.embedded.InfinispanCacheConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 10:47
 * @description：Infinispan配置
 * @modified By：
 * @version: $
 *
 * 参考 org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
 *
 */
@Configuration
public class InfinispanConfig {

    /**
     * 自定义infinispan配置
     * @return
     */
    @Bean
    public InfinispanCacheConfigurer cacheConfigurer() {
        return manager -> {
            final org.infinispan.configuration.cache.Configuration ispnConfig = new ConfigurationBuilder()
                    .clustering()
                    .cacheMode(CacheMode.LOCAL)
                    .build();

            //配置，需要与注解cache一致
            manager.defineConfiguration("user", ispnConfig);
        };
    }

    @Bean
    public EmbeddedCacheManager infinispanCacheManager(InfinispanCacheConfigurer infinispanCacheConfigurer){
        EmbeddedCacheManager embeddedCacheManager = new DefaultCacheManager();
        infinispanCacheConfigurer.configureCache(embeddedCacheManager);
        return embeddedCacheManager;
    }


    @Bean("cacheManager")
    @Primary
    public SpringEmbeddedCacheManager cacheManager(@Qualifier("infinispanCacheManager") EmbeddedCacheManager embeddedCacheManager) {
        return new SpringEmbeddedCacheManager(embeddedCacheManager);
    }

}
