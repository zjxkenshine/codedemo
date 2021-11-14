package com.kenshine.memcached.config.memcached;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 20:24
 * @description：XMemcached配置
 * @modified By：
 * @version: 1.0$
 */
@ConfigurationProperties(prefix = "spring.memcached")
@PropertySource("classpath:application.yml")
@Configuration
@Data
public class XMemcachedProperties {
    /**
     * memcached服务器节点
     */
    private String servers;

    /**
     * nio连接池的数量
     */
    private Integer poolSize;

    /**
     * 设置默认操作超时
     */
    private Long opTimeout;

    /**
     * 是否启用url encode机制
     */
    private Boolean sanitizeKeys;

}
