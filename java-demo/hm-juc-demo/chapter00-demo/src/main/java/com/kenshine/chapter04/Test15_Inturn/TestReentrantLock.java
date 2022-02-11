package com.kenshine.chapter04.Test15_Inturn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 12:51
 * @description：交替输出模式 ReentrantLock实现
 * @modified By：
 * @version: $
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        AwaitAndSignal lock = new AwaitAndSignal(5);
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        new Thread(() -> {
            lock.run("a", a, b);
        }).start();

        new Thread(() -> {
            lock.run("b", b, c);
        }).start();

        new Thread(() -> {
            lock.run("c", c, a);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {
            a.signal();
        }finally {
            lock.unlock();
        }
    }
}

class AwaitAndSignal extends ReentrantLock {
    public void run(String str, Condition current, Condition nextCondition) {
        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                current.await();
                System.out.print(str);
                nextCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }

    private int loopNumber;

    public AwaitAndSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }
}
