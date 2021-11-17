package com.kenshine.hippo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 9:03
 * @description：Springboot整合Hippo4j动态线程池
 * @modified By：
 * @version: $
 *
 * @TODO 有点问题，等1.0版本上线后再测试
 */
@SpringBootApplication
public class Hippo4jApp {

    public static void main(String[] args) {
        SpringApplication.run(Hippo4jApp.class,args);
    }

}
