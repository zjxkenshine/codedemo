package com.kenshine.profile.demo;

import com.kenshine.profile.annotation.Group;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 18:28
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class DemoConfig {

    @Profile("dev")
    @Bean
    public Demo getDemo01(){
        return new Demo("dev");
    }

    @Profile("prod")
    @Bean
    public Demo getDemo02(){
        return new Demo("prod");
    }

    @Profile("default")
    @Bean
    public Demo getDemo03(){
        return new Demo("default");
    }

    @Group("A")
    @Bean
    public GroupBean getGroupBean1(){
        return new GroupBean("A");
    }

    @Group("B")
    @Bean
    public GroupBean getGroupBean2(){
        return new GroupBean("B");
    }
}
