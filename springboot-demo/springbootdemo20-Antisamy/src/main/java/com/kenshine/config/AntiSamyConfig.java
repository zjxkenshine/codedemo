package com.kenshine.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.kenshine.filter.XssFilter;
import com.kenshine.wrapper.XssRequestWrapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.servlet.Filter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 8:35
 * @description：AntiSamy配置类
 * @modified By：
 * @version: $
 */
@Configuration
public class AntiSamyConfig {
    /**
     * 配置XSS过滤器
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>(new XssFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    /**
     * 用于过滤Json类型数据的解析器
     *
     * @param builder Jackson2ObjectMapperBuilder
     * @return ObjectMapper
     */
    @Bean
    public ObjectMapper xssObjectMapper(Jackson2ObjectMapperBuilder builder) {
        // 创建解析器
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 注册解析器
        SimpleModule simpleModule = new SimpleModule("XssStringJsonSerializer");
        simpleModule.addSerializer(new XssRequestWrapper.XssStringJsonSerializer());
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }

}
