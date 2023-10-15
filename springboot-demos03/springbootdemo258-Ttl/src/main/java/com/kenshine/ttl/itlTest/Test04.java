package com.kenshine.ttl.itlTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 0:12
 * @description：线程池传递失效
 * @modified By：
 * @version: $
 */
public class Test04 {
    // 为了方便观察，我们假定线程池里只有一个线程
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static ThreadLocal tl = new InheritableThreadLocal<>();

    public static void main(String[] args) throws Exception{

        System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        executorService.execute(()->{
            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        });

        tl.set(1); // 等上面的线程池第一次启用完了，父线程再给自己赋值

        executorService.execute(()->{
            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        });

        System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
    }
}
