package com.kenshine.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.StampedLock;
import static com.kenshine.chapter02.util.Sleeper.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 14:22
 * @description：StampLock读写锁的使用
 * @modified By：
 * @version: $
 */
public class Test04_StampLock {
    public static void main(String[] args) {
        DataContainerStamped dataContainer = new DataContainerStamped(1);
        new Thread(() -> {
            dataContainer.read(1);
        }, "t1").start();
        sleep(0.5);
        new Thread(() -> {
            dataContainer.read(0);
        }, "t2").start();
    }
}

@Slf4j(topic = "c.DataContainerStamped")
class DataContainerStamped {
    private int data;
    private final StampedLock lock = new StampedLock();

    public DataContainerStamped(int data) {
        this.data = data;
    }

    public int read(int readTime) {
        // 乐观读获取戳
        long stamp = lock.tryOptimisticRead();
        log.debug("optimistic read locking...{}", stamp);
        sleep(readTime);
        // 验戳 失败则进行锁升级
        if (lock.validate(stamp)) {
            log.debug("read finish...{}, data:{}", stamp, data);
            return data;
        }
        // 锁升级 -乐观读锁升级为读锁
        log.debug("updating to read lock... {}", stamp);
        try {
            // 读锁
            stamp = lock.readLock();
            log.debug("read lock {}", stamp);
            sleep(readTime);
            log.debug("read finish...{}, data:{}", stamp, data);
            return data;
        } finally {
            log.debug("read unlock {}", stamp);
            // 解锁
            lock.unlockRead(stamp);
        }
    }

    public void write(int newData) {
        // 写锁
        long stamp = lock.writeLock();
        log.debug("write lock {}", stamp);
        try {
            sleep(2);
            this.data = newData;
        } finally {
            log.debug("write unlock {}", stamp);
            lock.unlockWrite(stamp);
        }
    }
}
