package com.kenshine.autolog.config;

import com.github.houbb.auto.log.spring.annotation.EnableAutoLog;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author by kenshine
 * @Classname AutoLogConfig
 * @Description 配置
 * @Date 2023-11-06 8:41
 * @modified By：
 * @version: 1.0$
 */
@Configuration
@ComponentScan(basePackages = "com.kenshine.autolog")
@EnableAutoLog
@PropertySource("classpath:autoLogConfig.properties")
public class AutoLogConfig {
}
