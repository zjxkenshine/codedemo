package com.kenshine.perf4j;

import org.perf4j.slf4j.aop.TimingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by kenshine
 * @Classname Config
 * @Description 配置
 * @Date 2023-10-26 11:45
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class Config {
    @Bean
    public TimingAspect configPerf(){
        return new TimingAspect();
    }
}
