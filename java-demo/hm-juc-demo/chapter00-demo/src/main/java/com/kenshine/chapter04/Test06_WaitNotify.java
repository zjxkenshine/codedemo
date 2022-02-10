package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/10 9:36
 * @description：wait/notify
 * @modified By：
 * @version: $
 * 使用方式
 * synchronized (lock) {
 * 	while(//不满足条件，一直等待，避免虚假唤醒) {
 * 		lock.wait();
 *        }
 * 	//满足条件后再运行
 * }
 *
 * synchronized (lock) {
 * 	//唤醒所有等待线程
 * 	lock.notifyAll();
 * }
 */
@Slf4j(topic = "c.Wait")
public class Test06_WaitNotify {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (room) {
                log.debug("有烟吗？[{}]",hasCigarette);
                while (!hasCigarette) {
                    log.debug("没烟，歇会");
                    try {
                        room.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有烟没？[{}]",hasCigarette);
                if (hasCigarette) {
                    log.debug("可以干活了");
                }
            }
        },"t1").start();

        new Thread(() -> {
            synchronized (room) {
                Thread thread = Thread.currentThread();
                log.debug("外卖送到没？[{}]",hasTakeout);
                while (!hasTakeout) {
                    log.debug("没外卖，歇会");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("外卖送到没？[{}]",hasTakeout);
                if (hasTakeout) {
                    log.debug("可以干活了");
                } else {
                    log.debug("没干成活");
                }
            }
        },"t2").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    log.debug("可以干活了");
                }
            },"其他人").start();
        }

        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (room) {
                hasCigarette = true;
                log.debug("烟来了");
                room.notifyAll();
            }
        },"送烟的").start();

        new Thread(() -> {
            synchronized (room) {
                hasTakeout = true;
                log.debug("外卖来了");
                room.notifyAll();
            }
        },"送外卖的").start();
    }
}
