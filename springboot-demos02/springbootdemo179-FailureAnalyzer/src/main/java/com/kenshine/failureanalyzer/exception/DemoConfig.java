package com.kenshine.failureanalyzer.exception;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 12:23
 * @description：配置抛出异常
 * @modified By：
 * @version: $
 */
@Configuration
public class DemoConfig {
    @Bean
    public CommandLineRunner commandLineRunner() throws CustomException {
        throw new CustomException("Custom异常");

    }
}
