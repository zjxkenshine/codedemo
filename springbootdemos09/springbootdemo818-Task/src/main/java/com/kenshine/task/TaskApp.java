package com.kenshine.task;

import idea.verlif.spring.taskservice.EnableTaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname TaskApp
 * @Description 测试项目
 * @Date 2024-05-18 8:25
 * @modified By：
 * @version: 1.0$
 */
@EnableTaskService
@SpringBootApplication
public class TaskApp {
    public static void main(String[] args) {
        SpringApplication.run(TaskApp.class, args);
    }
}
