package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.kenshine.chapter02.util.Sleeper.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 17:38
 * @description：ScheduledExecutorService 定时任务
 * @modified By：
 * @version: $
 *
 */
@Slf4j(topic = "c.ScheduledExecutorService")
public class Test08_ScheduledExecutorService {
    public static void main(String[] args) {
        // 基本使用
        //method1();
        // scheduleAtFixedRate
        method2();
        //scheduleWithFixedDelay
        //method3();
    }

    private static void method3() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        log.debug("start...");
        // scheduleWithFixedDelay
        // 一开始，延时 1s，scheduleWithFixedDelay 的间隔是 上一个任务结束 <-> 延时 <-> 下一个任务开始 所以间隔都是 3s
        pool.scheduleWithFixedDelay(()-> {
            log.debug("running...");
            sleep(2);
        }, 1, 1, TimeUnit.SECONDS);
    }

    private static void method2() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        log.debug("start...");
        // scheduleAtFixedRate
        // 一开始，延时 1s，接下来，由于任务执行时间 > 间隔时间，间隔被『撑』到了 2s
        pool.scheduleAtFixedRate(() -> {
            log.debug("running...");
            sleep(2);
        }, 1, 1, TimeUnit.SECONDS);
    }


    public static void method1(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.schedule(() -> {
            System.out.println("任务1，执行时间：" + new Date());
            try {
                // 第一个任务执行时间较长
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000, TimeUnit.MILLISECONDS);

        executorService.schedule(() -> {
            System.out.println("任务2，执行时间：" + new Date());
        },1000, TimeUnit.MILLISECONDS);
    }
}


