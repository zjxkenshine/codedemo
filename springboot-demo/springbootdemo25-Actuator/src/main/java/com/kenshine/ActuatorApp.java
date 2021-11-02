package com.kenshine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 16:41
 * @description：监控测试App
 * @modified By：
 * @version: $
 *
 * TODO springboot admin 可视化监控并告警
 */
@SpringBootApplication
public class ActuatorApp {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApp.class,args);
    }
}
