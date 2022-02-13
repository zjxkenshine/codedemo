package com.kenshine.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 15:29
 * @description： CountDownLatch01
 * @modified By：
 * @version: $
 */
@Slf4j
@SuppressWarnings("all")
public class Test08_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        //method1();
        //method2();
        method3();
    }

    // 基本使用
    public static void method1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            log.info("t1 start ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t1 end ...");
            countDownLatch.countDown();
        },"t1").start();

        new Thread(() -> {
            log.info("t2 start ...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t2 end ...");
            countDownLatch.countDown();
        }, "t2").start();

        new Thread(() -> {
            log.info("t3 start ...");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t3 end ...");
            countDownLatch.countDown();
        }, "t3").start();

        log.info("main wait ...");
        countDownLatch.await();
        log.info("main wait end ...");
    }

    // 2.线程池改进
    public static void method2() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> {
            log.info("t1 start ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            log.info("t1 end ...{}", countDownLatch.getCount());
        });

        executorService.submit(() -> {
            log.info("t2 start ...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t2 end ...{}", countDownLatch.getCount());
            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            log.info("t3 start ...");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t3 end ...{}", countDownLatch.getCount());
            countDownLatch.countDown();
        });

        executorService.submit(() -> {
            log.info("main wait...");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("main wait end ...");
            executorService.shutdown();
        });
    }

    // 3.模拟等待所有玩家进度加载完成，游戏开始
    public static void method3() throws InterruptedException {
        // 10个线程执行完毕后开始
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        String[] all = new String[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int id = i;
            executorService.submit(() -> {
                for (int j = 0; j <= 100; j++) {
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    all[id] = j + "%";
                    System.out.print("\r" + Arrays.toString(all));
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println();
        System.out.println("游戏开始");
        executorService.shutdown();
    }
}



