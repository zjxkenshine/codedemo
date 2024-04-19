package com.kenshine.referer.config;

import com.kenshine.referer.interceptor.RefererInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kenshine
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    public RefererInterceptor refererInterceptor() {
        return new RefererInterceptor();
    }
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //referer拦截
        registry.addInterceptor(refererInterceptor());
    }

}