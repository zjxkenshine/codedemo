package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

import static com.kenshine.chapter02.util.Sleeper.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 10:17
 * @description：活锁
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.TestLiveLock")
public class Test13_LiveLock {
    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            // 期望减到 0 退出循环
            while (count > 0) {
                sleep(0.2);
                count--;
                log.debug("count: {}", count);
            }
        }, "t1").start();
        new Thread(() -> {
            // 期望超过 20 退出循环
            while (count < 20) {
                sleep(0.2);
                count++;
                log.debug("count: {}", count);
            }
        }, "t2").start();
    }
}

