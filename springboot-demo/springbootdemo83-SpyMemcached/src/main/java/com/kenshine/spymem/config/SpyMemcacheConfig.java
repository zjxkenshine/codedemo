package com.kenshine.spymem.config;

import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 20:43
 * @description：配置
 * @modified By：
 * @version: $
 */
@Configuration
public class SpyMemcacheConfig implements CommandLineRunner {

    @Value("${memcache.ip}")
    private String ip;
    @Value("${memcache.port}")
    private int port;

    private MemcachedClient client = null;

    @Override
    public void run(String... args) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(ip,port));
        } catch (IOException e) {
        }
    }

    public MemcachedClient getClient() {
        return client;
    }

}
