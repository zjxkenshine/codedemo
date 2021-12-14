package com.kenshine.aware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 22:25
 * @description：Aware接口族作用
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class EnvAwareApp {
    public static void main(String[] args) {
        SpringApplication.run(EnvAwareApp.class,args);
    }
}
