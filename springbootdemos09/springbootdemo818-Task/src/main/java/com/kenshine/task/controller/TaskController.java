package com.kenshine.task.controller;

import com.kenshine.task.service.TaskTest;
import idea.verlif.spring.taskservice.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TaskController
 * @Description 测试
 * @Date 2024-05-18 8:54
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TaskController {
    @Resource
    private TaskTest taskTest;

    @Resource
    private TaskService taskService;

    /**
     * 自动任务
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public String test01(){
        taskTest.task3();
        return "success";
    }

    /**
     * 自动任务
     * localhost:8080/test01
     */
    @GetMapping("/test02")
    public String test02(){
        Runnable task = () -> {
            System.out.println("test02");
        };
        // 使用注解名称或默认名称添加可重复任务
        taskService.insert(task);
        // 使用动态名称添加可重复任务
        //taskService.insert("name", task);
        // 取消名为[name]的任务
        //taskService.cancel("name");
        // 2000毫秒后执行任务
        taskService.delay(task, 2000);
        return "success";
    }
}
