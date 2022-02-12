package com.kenshine.chapter08;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 18:07
 * @description：
 * @modified By：
 * @version: $
 * 使用 newScheduledThreadPool 中的 scheduleAtFixedRate 这个方法可以执行定时任务
 */
public class Test08_NewScheduledThreadPool {
    public static void main(String[] args) {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 获取每周四晚时间
        LocalDateTime time = now.withHour(18).withMinute(0).withSecond(0).withNano(0).with(DayOfWeek.THURSDAY);
        if(now.compareTo(time) > 0) {
            time = time.plusWeeks(1);
        }

        long initalDelay = Duration.between(now, time).toMillis();
        // 一周的时间
        long period = 1000 * 60 * 60 * 24 * 7;
        // initalDelay 表示当前时间与周四的时间差, period 一周的间隔时间。
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        // 创建一个定时任务, 每周四 18:00:00 执行。
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("running");
        }, initalDelay, period, TimeUnit.MILLISECONDS);
    }
}
