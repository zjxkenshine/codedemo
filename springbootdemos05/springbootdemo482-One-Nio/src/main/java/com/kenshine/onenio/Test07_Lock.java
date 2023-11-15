package com.kenshine.onenio;

import lombok.SneakyThrows;
import one.nio.lock.RWLock;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test07_Lock
 * @Description 读写锁
 * @Date 2023-11-15 8:07
 * @modified By：
 * @version: 1.0$
 */
public class Test07_Lock {

    /**
     * 读线程
     */
    public class ReadThread extends Thread{
        private RWLock lock;
        public ReadThread(RWLock lock){
            this.lock=lock;
        }
        @SneakyThrows
        @Override
        public void run() {
            lock.lockRead();
            System.out.println("执行读操作");
            Thread.sleep(1000);
            lock.unlockRead();
        }
    }

    /**
     * 写线程
     */
    public class WriteThread extends Thread{
        private RWLock lock;
        public WriteThread(RWLock lock){
            this.lock=lock;
        }

        @SneakyThrows
        @Override
        public void run() {
            lock.lockWrite();
            System.out.println("执行写操作");
            Thread.sleep(1000);
            lock.unlockWrite();
        }
    }


    /**
     * RWLock 读写锁
     * tryAcquireShared：获取共享锁
     * tryReleaseShared：释放共享锁
     */
    @Test
    public void testRwLock() throws InterruptedException {
        RWLock lock=new RWLock();
        // 写写互斥，读写互斥，读读共享
        new WriteThread(lock).start();
        new WriteThread(lock).start();
        new ReadThread(lock).start();
        new ReadThread(lock).start();
        Thread.sleep(2500);
    }
}
