package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author kenshine
 * 开启EurekaClient注解,目前版本如果配置了Eureka注册中心，默认会开启该注解
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class OrderServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceFeignApplication.class,args);
    }
}
