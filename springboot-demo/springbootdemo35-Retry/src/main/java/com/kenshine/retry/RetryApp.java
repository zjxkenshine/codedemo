package com.kenshine.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 17:00
 * @description：接口重试测试
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class RetryApp {
    public static void main(String[] args) {
        SpringApplication.run(RetryApp.class,args);
    }
}
