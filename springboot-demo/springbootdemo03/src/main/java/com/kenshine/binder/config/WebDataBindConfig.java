package com.kenshine.binder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 15:53
 * @description：测试ConfigurableWebBindingInitializer
 * @modified By：
 * @version: $
 */
@Configuration
public class WebDataBindConfig {

    @Bean
    ConfigurableWebBindingInitializer configurableWebBindingInitializer(){
        return new ConfigurableWebBindingInitializer();
    }

}
