package com.kenshine.demo02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //作为配置类，替代 xml 配置文件
@ComponentScan(basePackages = {"com.kenshine.demo02"})
public class SpringConfig {
    
}