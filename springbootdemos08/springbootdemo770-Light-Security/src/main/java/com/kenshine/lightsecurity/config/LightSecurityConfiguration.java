package com.kenshine.lightsecurity.config;

import com.itmuch.lightsecurity.enums.HttpMethod;
import com.itmuch.lightsecurity.spec.SpecRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kenshine
 * 代码配置，可将application.yml中的配置删除
 */
@Configuration
public class LightSecurityConfiguration {
//    @Bean
//    public SpecRegistry specRegistry() {
//        return new SpecRegistry()
//                .add(HttpMethod.GET, "/user", "hasAnyRoles('user')")
//                .add(HttpMethod.ANY, "/**", "hasLogin()");
//    }
}