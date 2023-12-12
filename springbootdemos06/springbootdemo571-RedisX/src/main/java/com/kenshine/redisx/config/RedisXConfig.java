package com.kenshine.redisx.config;

import com.kenshine.redisx.properties.RedisProperties;
import org.noear.redisx.RedisClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname RedisXConfig
 * @Description redisx客户端
 * @Date 2023-12-12 8:20
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class RedisXConfig {
    @Resource
    private RedisProperties redisProperties;

    @Bean
    public RedisClient init(){
        Properties props = new Properties();
        props.put("server", redisProperties.getServer());
        props.put("user", redisProperties.getUser());
        props.put("db", redisProperties.getDb());
        if(redisProperties.getPassword()!=null&&!"".equals(redisProperties.getPassword())){
            props.put("password", redisProperties.getPassword());
        }
        props.put("maxWaitMillis", redisProperties.getMaxWaitMillis());
        props.put("maxTotal", redisProperties.getMaxTotal());
        props.put("maxIdle", redisProperties.getMaxIdle());
        props.put("minIdle", redisProperties.getMinIdle());
        props.put("connectionTimeout", redisProperties.getConnectionTimeout());
        props.put("socketTimeoutMillis", redisProperties.getSocketTimeoutMillis());
        props.put("maxAttempts", redisProperties.getMaxAttempts());
        if(redisProperties.getPassword()!=null&&!"".equals(redisProperties.getPassword())){
            props.put("serializer", redisProperties.getSerializer());
        }
        RedisClient client = new RedisClient(props);
        return client;
    }
}
