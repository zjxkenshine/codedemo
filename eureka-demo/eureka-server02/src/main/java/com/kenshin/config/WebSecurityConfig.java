package com.kenshin.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全认证配置类
 * @author Kenshine
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //方案一：忽略 /eureka/** 的所有请求
        //为了访问 /eureka 和 /actuator 时能做安全控制
        super.configure(http);
        //忽略 /eureka/** 的所有请求
        http.csrf().ignoringAntMatchers("/eureka/**");


        //方案二：直接关闭CSRF防御机制
        //注意，如果直接disable的话会把安全验证也去调
      /**  http.csrf().disable().authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        **/
    }
}
