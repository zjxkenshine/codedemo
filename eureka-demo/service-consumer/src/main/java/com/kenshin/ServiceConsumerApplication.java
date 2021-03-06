package com.kenshin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author kenshine
 */
//开启EurekaClient注解,目前版本如果配置了Eureka注册中心，默认会开启该注解
@EnableEurekaClient
@SpringBootApplication
public class ServiceConsumerApplication {

    /**
     * 需要手动添加RestTemplate
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class,args);
    }
}
