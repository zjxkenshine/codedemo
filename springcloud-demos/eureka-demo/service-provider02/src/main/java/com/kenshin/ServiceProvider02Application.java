package com.kenshin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kenshine
 * 开启EurekaClient注解,目前版本如果配置了Eureka注册中心，默认会开启该注解
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceProvider02Application {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider02Application.class,args);
    }
}
