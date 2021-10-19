package com.kenshine;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author kenshine
 * 开启EurekaClient注解,目前版本如果配置了Eureka注册中心，默认会开启该注解
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ServiceConsumerApplication {
    /**
     * Feign负载均衡全局策略
     */
//    @Bean
//    public RandomRule randomRule(){
//        return new RandomRule();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class,args);
    }
}
