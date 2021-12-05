package com.kenshine.argumentresolver.config;

import com.kenshine.argumentresolver.resolvers.PhoneNumberResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 13:44
 * @description：配置
 * @modified By：
 * @version: $
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //添加自定义参数校验器
        argumentResolvers.add(new PhoneNumberResolver());
    }

}
