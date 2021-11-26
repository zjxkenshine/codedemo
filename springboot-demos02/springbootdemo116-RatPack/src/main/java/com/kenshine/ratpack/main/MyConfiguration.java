package com.kenshine.ratpack.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 11:16
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class MyConfiguration {
    @Bean
    public Service service() {
        return () -> "World!";
    }
}
