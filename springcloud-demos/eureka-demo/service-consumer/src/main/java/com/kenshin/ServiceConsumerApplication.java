package com.kenshin;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author kenshine
 * 开启EurekaClient注解,目前版本如果配置了Eureka注册中心，默认会开启该注解
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceConsumerApplication {


    /**
     * 配置全局负载均衡
     * 局部需要在application.yml中额外配置
     */
    @Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }


    /**
     * 需要手动添加RestTemplate
     * 使用loadBalancerClient负载均衡器时不要用LoadBalanced注解
     * @return
     */
    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class,args);
    }
}
