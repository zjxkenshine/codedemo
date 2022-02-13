package com.kenshine.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 10:08
 * @description：AQS示例，自定义锁
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.AQS")
public class Test01_AQS {
    public static void main(String[] args) {
        MyLock lock = new MyLock();

        new Thread(()->{
            lock.lock();
            // 不可重入
            // lock.lock();
            try {
                log.debug("locking...");
            } finally {
                log.debug("unlocking...");
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            lock.lock();
            try {
                log.debug("locking...");
            } finally {
                log.debug("unlocking...");
                lock.unlock();
            }
        },"t2").start();
    }
}

// 自定义锁（不可重入锁）
class MyLock implements Lock{
    // 独占锁，内部队列同步器
    class MySync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            // 將state状态从0变为1
            if(compareAndSetState(0,1)){
                // 加上了锁,并设置 owner 为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        protected Condition newCondition(){
            // 条件对象
            return new ConditionObject();
        }
    }

    // 加锁
    private MySync sync = new MySync();

    // 加锁(不成功会进入等待队列)
    @Override
    public void lock() {
        sync.acquire(1);
    }

    // 加锁，可打断
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    // 尝试加锁
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    // 超时尝试加锁
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    // 解锁
    @Override
    public void unlock() {
        sync.release(1);
    }

    // 创建条件变量
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}

