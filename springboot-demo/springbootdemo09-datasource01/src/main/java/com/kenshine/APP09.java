package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:02
 * @description：分包实现多数据源
 * @modified By：
 * @version: $
 * @SpringBootApplication(scanBasePackages = {"com.kenshine.dao.*"})
 */
@SpringBootApplication
public class APP09 {
    public static void main(String[] args) {
        SpringApplication.run(APP09.class,args);
    }
}
