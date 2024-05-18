package com.kenshine.task.service;

import idea.verlif.spring.taskservice.TaskType;
import idea.verlif.spring.taskservice.anno.TaskTip;
import idea.verlif.spring.taskservice.anno.TaskTipHead;

/**
 * 添加3个延时任务（由@TaskTipHead声明task2与task3任务会被加载，并且只有在运行配置包括了dev或local的情况下才会生效
 * @author kenshine
 */
@TaskTipHead(profiles = {"dev", "local"})
@TaskTip(name = "test", type = TaskType.DELAY, delay = 2000)
public class TaskTest implements Runnable {

    @Override
    public void run() {
        System.out.println("任务开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务结束");
    }

    @TaskTip(name = "task2", type = TaskType.DELAY, delay = 1000)
    private String task2() {
        System.out.println("say hello");
        return hello();
    }
    
    private String hello() {
        return "hello";
    }

    @TaskTip(name = "task3", type = TaskType.DELAY, delay = 1000)
    public void task3() {
        System.out.println("task3 is running!");
    }
}