package com.kenshine.chapter04.Test14_RetrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.TestReentrant")
public class TestReentrant {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        lock.lock();
        try {
            log.debug("执行method1");
            method2();
        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        // 对同一个锁对象加锁解锁
        lock.lock();
        try {
            log.debug("执行method2");
            method3();
        } finally {
            lock.unlock();
        }
    }

    public static void method3() {
        lock.lock();
        try {
            log.debug("执行method3");
        } finally {
            lock.unlock();
        }
    }
}
