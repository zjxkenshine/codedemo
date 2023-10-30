package com.kenshine.cron4j;

import it.sauronsoftware.cron4j.Scheduler;

/**
 * @author by kenshine
 * @Classname DemoTest
 * @Description 测试
 * @Date 2023-10-30 10:49
 * @modified By：
 * @version: 1.0$
 */
public class DemoTest {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.schedule("* * * * *", new Runnable() {
            @Override
            public void run() {
                System.out.println("Every Minute Run.");
            }
        });
        // 开启
        scheduler.start();
        try {
            Thread.sleep(1000L * 60L * 10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.stop();
    }
}
