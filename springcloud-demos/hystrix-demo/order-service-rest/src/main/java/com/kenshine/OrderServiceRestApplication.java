package com.kenshine;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author kenshine
 * 开启Redis缓存，EurekaClient会自动开启，不用写注解
 * EnableCircuitBreaker 开启熔断器注解（与@EnableHystrix二选一）
 */
@EnableCircuitBreaker
@EnableCaching
@SpringBootApplication
//开启数据监控
@EnableHystrixDashboard
public class OrderServiceRestApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderServiceRestApplication.class,args);
    }
}
