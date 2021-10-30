package com.kenshine.jwt.config;

import com.kenshine.jwt.intercepters.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 9:12
 * @description：拦截器配置
 * @modified By：
 * @version: $
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor()).
                excludePathPatterns("/user/**")  // 放行
                .addPathPatterns("/**"); // 拦截除了"/user/**的所有请求路径
    }

}
