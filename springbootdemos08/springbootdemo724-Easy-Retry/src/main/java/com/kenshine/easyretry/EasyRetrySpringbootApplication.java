package com.kenshine.easyretry;

import com.aizuda.easy.retry.client.starter.EnableEasyRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname EasyRetrySpringbootApplication
 * @Description EasyRetry接入测试
 * @Date 2024-03-05 9:20
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableEasyRetry(group = "easy_retry_demo_group")
public class EasyRetrySpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyRetrySpringbootApplication.class, args);
    }
}
