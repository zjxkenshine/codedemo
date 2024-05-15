package com.kenshine.logging;

import idea.verlif.spring.logging.EnableLogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname LoggingApp
 * @Description log日志测试App
 * @Date 2024-05-15 8:39
 * @modified By：
 * @version: 1.0$
 */
@EnableLogService
@SpringBootApplication
public class LoggingApp {
    public static void main(String[] args) {
        SpringApplication.run(LoggingApp.class, args);
    }
}
