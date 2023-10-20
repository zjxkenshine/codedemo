package com.kenshine.wast.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@Configuration
  public class AppConfiguration implements WebMvcConfigurer {
 
       @Bean
       public HttpMessageConverters jsonHttpMessageConverters() {
           JsonbHttpMessageConverter jsonHttpMessageConverter = new JsonbHttpMessageConverter();
           return new HttpMessageConverters(jsonHttpMessageConverter);
       }
 
  }