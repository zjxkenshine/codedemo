package com.kenshine.chapter04.Test14_RetrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static com.kenshine.chapter02.util.Sleeper.sleep;

/**
 * lock.tryLock 尝试获取锁 超时获取
 * - 不设置等待时间 立即返回，不是永久等待
 * - 支持Interrupt 打断
 */
@Slf4j(topic = "c.TestTimeout")
public class TestTimeout {
    public static void main(String[] args) {
        // 设置等待时间
        test1();
        // 不设置等待时间
        // test2();
    }

    private static void test1() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            log.debug("启动...");
            try {
                if (!lock.tryLock(1, TimeUnit.SECONDS)) {
                    log.debug("获取等待 1s 后失败，返回");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            try {
                log.debug("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        log.debug("获得了锁");
        t1.start();
        try {
            sleep(1);
        } finally {
            lock.unlock();
        }
    }
    private static void test2() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            log.debug("启动...");
            if (!lock.tryLock()) {
                log.debug("获取立刻失败，返回");
                return;
            }
            try {
                log.debug("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        log.debug("获得了锁");
        t1.start();
        try {
            sleep(1);
        } finally {
            lock.unlock();
        }
    }
}
