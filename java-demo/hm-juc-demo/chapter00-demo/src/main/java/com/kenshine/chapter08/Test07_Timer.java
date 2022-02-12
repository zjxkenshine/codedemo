package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 17:18
 * @description：Timer类的使用
 * @modified By：
 * @version: $
 * Timer缺点：所有任务都是由同一个线程来调度，因此所有任务都是串行执行的
 */
@Slf4j(topic = "c.Timer")
public class Test07_Timer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                log.debug("task 1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                log.debug("task 2");
            }
        };

        // 使用 timer 添加两个任务，希望它们都在 1s 后执行
        // 但由于 timer 内只有一个线程来顺序执行队列中的任务，因此『任务1』的延时，影响了『任务2』的执行
        timer.schedule(task1,1000);
        timer.schedule(task2,1000);

    }
}
