package com.kenshine.starter.config;

import com.kenshine.starter.properties.TestProperties;
import com.kenshine.starter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 16:15
 * @description：测试Starter
 * @modified By：
 * @version: $
 */
@SuppressWarnings("all")
@Configuration
@EnableConfigurationProperties(value = TestProperties.class)
//仅在test.config.enable配置为true是进行配置
@ConditionalOnProperty(prefix = "test.config", name = "enable", havingValue = "true", matchIfMissing = false)
public class TestConfig {
    @Autowired
    private TestProperties properties;

    @Bean
    @ConditionalOnMissingBean(TestService.class)
    public TestService defaultWebConfig() {
        return new TestService(properties.getUser(), properties.getPassword(), properties.getSalt());
    }

}
