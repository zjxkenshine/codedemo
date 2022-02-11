package com.kenshine.chapter06;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 21:29
 * @description：CAS实现加锁
 * @modified By：
 * @version: $
 * 业务代码中不要这么写
 */
@Slf4j(topic = "c.lockCAS")
public class Test10_LockCAS {
    public AtomicInteger state = new AtomicInteger(0); // 如果 state 值为 0 表示没上锁, 1 表示上锁

    public void lock() {
        while (true) {
            if(state.compareAndSet(0, 1)) {
                break;
            }
        }
    }

    public void unlock() {
        log.debug("unlock...");
        state.set(0);
    }

    public static void main(String[] args) {
        Test10_LockCAS lock = new Test10_LockCAS();
        new Thread(() -> {
            log.info("begin...");
            lock.lock();
            try {
                log.info("上锁成功");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();
        new Thread(() -> {
            log.info("begin...");
            lock.lock();
            try {
                log.info("上锁成功");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
