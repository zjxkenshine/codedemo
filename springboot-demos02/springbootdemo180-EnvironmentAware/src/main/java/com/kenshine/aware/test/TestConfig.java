package com.kenshine.aware.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 23:04
 * @description：测试
 * @modified By：
 * @version: $
 */
@Configuration
public class TestConfig {

    @Bean("testBean")
    public TestBean register(){
        return new TestBean();
    }
}
