package com.kenshine.redisx.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author by kenshine
 * @Classname RedisConfig
 * @Description redis配置
 * @Date 2023-12-12 8:39
 * @modified By：
 * @version: 1.0$
 */
@Data
@Component
@ConfigurationProperties(prefix="redisx")
public class RedisProperties {
    // "localhost:6379,localhost:6380"
    private String server;
    private String db;
    private String user;
    private String password;
    // 最大连接数
    private int maxTotal=200;
    // 最大空闲数
    private int maxIdle=200;
    // 最小空闲数
    private int minIdle=10;
    // 最大连接等待时间
    private int maxWaitMillis=3000;
    // 最大重试，集群模式有效
    private int maxAttempts=5;
    // 连接超时
    private int connectionTimeout=3000;
    // 	Socket超时
    private int socketTimeoutMillis=2000;
    private String serializer;
}
