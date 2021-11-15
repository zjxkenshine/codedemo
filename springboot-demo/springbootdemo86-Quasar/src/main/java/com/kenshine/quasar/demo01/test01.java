package com.kenshine.quasar.demo01;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/15 14:07
 * @description：测试1
 * @modified By：
 * @version: $
 * Quasar 的核心是 Fiber 类，Fiber 继承自 Future，有一个返回值，类型为泛型 V，Fiber 的使用和 Thread 类似
 *
 * 注意，debug会有警告，直接运行没有警告
 */
public class test01 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(1);
        Fiber fiber = new Fiber(() -> {
            System.out.println(1);
        });
        fiber.start();
        System.out.println(2);
        countDown.await();
    }
}
