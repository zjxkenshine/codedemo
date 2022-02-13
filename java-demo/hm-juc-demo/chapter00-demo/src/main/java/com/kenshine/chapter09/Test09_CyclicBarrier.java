package com.kenshine.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

import static com.kenshine.chapter02.util.Sleeper.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 16:01
 * @description： CyclicBarrier使用示例
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.CyclicBarrier")
public class Test09_CyclicBarrier {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(2, ()-> {
            log.debug("task1, task2 finish...");
        });
        for (int i = 0; i < 3; i++) { // task1  task2  task1
            service.submit(() -> {
                log.debug("task1 begin...");
                sleep(1);
                try {
                    barrier.await(); // 2-1=1
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            service.submit(() -> {
                log.debug("task2 begin...");
                sleep(2);
                try {
                    barrier.await(); // 1-1=0
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();

    }

    // CountDownLatch不能重用 latch
    private static void test1() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            CountDownLatch latch = new CountDownLatch(2);
            service.submit(() -> {
                log.debug("task1 start...");
                sleep(1);
                latch.countDown();
            });
            service.submit(() -> {
                log.debug("task2 start...");
                sleep(2);
                latch.countDown();
            });
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("task1 task2 finish...");
        }
        service.shutdown();
    }
}
