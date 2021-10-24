package com.kenshine.rocketmq02.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * rocketmq.producer yml文件配置读取类
 * @author Kenshine
 */
@Data
@ConfigurationProperties(prefix = "rocketmq.producer")
@Configuration
@ToString
public class ProducerConfig {
    //命名服务地址
    private String namesrvAddr;
    //分组名称
    private String groupName;

}
