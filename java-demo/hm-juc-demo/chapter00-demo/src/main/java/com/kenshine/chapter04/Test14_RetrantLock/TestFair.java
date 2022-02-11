package com.kenshine.chapter04.Test14_RetrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class TestFair {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(false);

        lock.lock();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " running...");
                } finally {
                    lock.unlock();
                }
            }, "t" + i).start();
        }

// 1s 之后去争抢锁
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " running...");
                } finally {
                    lock.unlock();
                }
            }, "强行插入").start();
        }
        lock.unlock();
    }
}
