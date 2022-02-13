package com.kenshine.chapter09;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 14:45
 * @description：Simaphore限流
 * @modified By：
 * @version: $
 * 《java并发编程的艺术》
 *
 * - `acquire()`：获取许可证
 * - `release()`：归还许可证
 * - `avalilablePermits()`：返回此信号量中当前可用许可证数
 * - `getQueueLength()`：返回正在等待获取许可证的线程数
 * - `hasQueuedThreads()`：是否有线程正在等待获取许可证
 * - `reducePermits(int reduction)`：减少reduction个许可证
 * - `Collection getQueuedThreads()`：返回等待获取许可证的线程集合
 */
public class Test06_Semaphore02 {
    public static void main(String[] args) {
        ExecutorService threadpool= Executors.newFixedThreadPool(30);
        Semaphore s=new Semaphore(10);  //限流

        //循环30次
        for(int i=0;i<30;i++){
            threadpool.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    s.acquire();    //获取许可证
                    System.out.println("连接数据库"); //同时只能10个连接，最终会打印出30个
                    s.release();    //使用完之后，归还许可证
                }
            });
        }
        threadpool.shutdown();
    }
}
