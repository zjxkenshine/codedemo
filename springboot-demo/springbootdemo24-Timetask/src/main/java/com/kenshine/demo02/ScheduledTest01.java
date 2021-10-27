package com.kenshine.demo02;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 15:54
 * @description：测试
 * @modified By：
 * @version: $
 *
 * commons lang3 BasicThreadFactory 方式创建线程
 */
public class ScheduledTest01 {

    public static void main(String[] args) {
        //org.apache.commons.lang3.concurrent.BasicThreadFactory
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder()
                        .namingPattern("schedule-pool-%d")
                        .daemon(true)
                        .build());

        // 参数：1.任务体;2.首次执行的延时时间;3.任务执行间隔;4.间隔时间单位.
        executorService.scheduleAtFixedRate(()->System.out.println("定时任务:"+new Date()), 0, 3, TimeUnit.SECONDS);
        //死循环查看效果
        for (;;){
        }
    }

}
