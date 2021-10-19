package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author kenshine
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer01Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer01Application.class);
    }

}
