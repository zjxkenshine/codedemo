package com.kenshine.logtube.config;

import io.github.logtube.http.LogtubeHttpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤配置
 * @author kenshine
 */
@Configuration
public class LogtubeFilter {
    @Bean
    public FilterRegistrationBean<LogtubeHttpFilter> someFilterRegistration() {
        FilterRegistrationBean<LogtubeHttpFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LogtubeHttpFilter());
        registration.addUrlPatterns("*");
        registration.setName("logtube-http");
        registration.setOrder(1);
        return registration;
    }
}