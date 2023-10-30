package com.kenshine.cron4j;

import it.sauronsoftware.cron4j.ProcessTask;
import it.sauronsoftware.cron4j.Scheduler;

/**
 * @author by kenshine
 * @Classname TaskTest
 * @Description 进程调度
 * @Date 2023-10-30 10:50
 * @modified By：
 * @version: 1.0$
 */
public class TaskTest {
    public static void main(String[] args) {
        // ProcessTask
        ProcessTask task = new ProcessTask("D:\\Program1\\Notepad++\\notepad++.exe");
        Scheduler scheduler = new Scheduler();
        scheduler.schedule("* * * * *", task);
        scheduler.start();
    }
}
