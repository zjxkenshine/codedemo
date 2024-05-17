package com.kenshine.permission.config;

import com.kenshine.permission.controller.DefaultPermissionDetector;
import idea.verlif.spring.permission.PermissionDetector;
import idea.verlif.spring.permission.PermissionHandler;
import idea.verlif.spring.permission.impl.DefaultPermissionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 配置
 */
@Configuration
public class PermissionConfig {

    @Bean
    @ConditionalOnMissingBean(PermissionDetector.class)
    public PermissionDetector<?> permissionDetector() {
        return new DefaultPermissionDetector();
    }

    @Bean
    @ConditionalOnMissingBean(PermissionHandler.class)
    public PermissionHandler permissionHandler() {
        return new DefaultPermissionHandler();
    }
}