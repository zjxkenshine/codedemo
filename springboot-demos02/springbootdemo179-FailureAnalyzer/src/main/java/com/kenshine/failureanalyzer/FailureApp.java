package com.kenshine.failureanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 10:25
 * @description：模拟启动失败的App
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class FailureApp {
    public static void main(String[] args) {
        SpringApplication.run(FailureApp.class,args);
    }
}
