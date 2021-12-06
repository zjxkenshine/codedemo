package com.kenshine.coherence.cache.config;

import com.oracle.coherence.spring.cache.CoherenceCacheManager;
import com.tangosol.net.Coherence;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/6 23:27
 * @description：配置缓存
 * @modified By：
 * @version: $
 */
@Configuration
@EnableCaching
public class CoherenceConfig {

    @Bean
    public CacheManager cacheManager(Coherence coherence) {
        return new CoherenceCacheManager(coherence);
    }
}
