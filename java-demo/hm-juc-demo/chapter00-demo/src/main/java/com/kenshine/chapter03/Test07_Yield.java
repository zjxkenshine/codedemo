package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/4 20:57
 * @description：挂起方法
 * @modified By：
 * @version: $
 * 调用 yield 会让当前线程从 Running 进入 Runnable 就绪状态，然后调度执行其它线程
 * 具体的实现依赖于操作系统的任务调度器
 */
@Slf4j(topic = "c.TestYield")
public class Test07_Yield {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (;;) {
                System.out.println("---->1 " + count++);
            }
        };
        Runnable task2 = () -> {
            int count = 0;
            for (;;) {
                Thread.yield();
                System.out.println("              ---->2 " + count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t1.start();
        t2.start();
    }
}
