package com.kenshine.exceptionCapture;

import idea.verlif.spring.exception.EnableExceptionCapture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname ExceptionApp
 * @Description 异常捕获测试
 * @Date 2024-05-06 9:19
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableExceptionCapture
public class ExceptionApp {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionApp.class, args);
    }
}
