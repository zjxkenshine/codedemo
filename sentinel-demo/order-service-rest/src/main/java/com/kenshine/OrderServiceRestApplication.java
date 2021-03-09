package com.kenshine;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.kenshine.exception.ExceptionUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author kenshine
 * 开启Redis缓存，EurekaClient会自动开启，不用写注解
 * EnableCircuitBreaker 开启熔断器注解（与@EnableHystrix二选一）
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderServiceRestApplication {

    @Bean
    @LoadBalanced
    @SentinelRestTemplate(
            blockHandler = "handleException",      //限流对应方法,必须是静态方法
            blockHandlerClass = ExceptionUtil.class,  //限流对应方法所在类名称
            fallback = "fallback" ,             //熔断降级对应方法,必须是静态方法
            fallbackClass = ExceptionUtil.class      //熔断降级方法所在类名称
    )
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderServiceRestApplication.class,args);
    }
}
