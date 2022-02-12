package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 16:24
 * @description：测试线程终止
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.TestShutDown")
public class Test05_Shutdown {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = pool.submit(() -> {
            log.debug("task 1 running...");
            Thread.sleep(1000);
            log.debug("task 1 finish...");
            return 1;
        });

        Future<Integer> result2 = pool.submit(() -> {
            log.debug("task 2 running...");
            Thread.sleep(1000);
            log.debug("task 2 finish...");
            return 2;
        });

        Future<Integer> result3 = pool.submit(() -> {
            log.debug("task 3 running...");
            Thread.sleep(1000);
            log.debug("task 3 finish...");
            return 3;
        });

        log.debug("shutdown");
//        pool.shutdown();
//        pool.awaitTermination(3, TimeUnit.SECONDS);
        // 正在运行的任务都会被打断并返回
        List<Runnable> runnables = pool.shutdownNow();
        log.debug("other.... {}" , runnables);
    }
}
