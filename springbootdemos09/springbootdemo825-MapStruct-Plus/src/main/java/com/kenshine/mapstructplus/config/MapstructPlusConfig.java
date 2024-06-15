package com.kenshine.mapstructplus.config;

import io.github.linpeilie.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapstructPlusConfig {
    @Bean
    public Converter converter() {
        return new Converter();
    }
}