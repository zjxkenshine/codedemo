package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 14:42
 * @description：newFixedThreadPool NewFixedThreadPool 创建固定大小的线程池
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.NewFixedThreadPool")
public class Test02_NewFixedThreadPool {
    public static void main(String[] args) {
        // 创建大小为 2 的固定线程池, 自定义线程名称
        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private AtomicInteger atomicInteger = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "my_thread_" + atomicInteger.getAndIncrement());
            }
        });
        // 开 3 个线程, 线程池大小为 2 , 第三个线程执行时, 如果前两个线程任务没执行完, 会加入任务队列.
        executorService.execute(() -> {
            log.info("1");
        });
        executorService.execute(() -> {
            log.info("2");
        });
        executorService.execute(() -> {
            log.info("3");
        });
    }
}
