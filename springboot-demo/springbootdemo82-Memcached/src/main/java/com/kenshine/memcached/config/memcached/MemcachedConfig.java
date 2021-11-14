package com.kenshine.memcached.config.memcached;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 20:25
 * @description：配置
 * @modified By：
 * @version: $
 */
@Configuration
@Slf4j
public class MemcachedConfig {
    @Autowired
    private XMemcachedProperties xMemcachedProperties;

    @Bean
    public MemcachedClient getMemcachedClinet(){
        MemcachedClient memcachedClient = null;
        try {
            MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(xMemcachedProperties.getServers()));
            builder.setFailureMode(false);
            builder.setSanitizeKeys(xMemcachedProperties.getSanitizeKeys());
            builder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
            builder.setOpTimeout(xMemcachedProperties.getOpTimeout());
            builder.setSessionLocator(new KetamaMemcachedSessionLocator());
            builder.setCommandFactory(new BinaryCommandFactory());
            memcachedClient = builder.build();
        }catch (IOException e){
            log.error("init MemcachedClient failed:", e);
        }
        return memcachedClient;
    }

}
