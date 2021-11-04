package com.kenshine.javamelody;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 20:50
 * @description：启动类
 * @modified By：
 * @version: $
 *
 * 监控地址
 * localhost:8080/monitoring
 * 账号密码在配置文件中
 */
@SpringBootApplication
public class JavaMelodyApp {
    public static void main(String[] args) {
        SpringApplication.run(JavaMelodyApp.class,args);
    }
}
