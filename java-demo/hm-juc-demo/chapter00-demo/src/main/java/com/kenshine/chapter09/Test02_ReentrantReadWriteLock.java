package com.kenshine.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 12:19
 * @description：读写锁
 * @modified By：
 * @version: $
 */
public class Test02_ReentrantReadWriteLock {
    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        new Thread(() -> {
            dataContainer.read();
            dataContainer.write();
        },"t1").start();

        new Thread(() -> {
            dataContainer.write();
        },"t2").start();
    }
}

@Slf4j(topic = "c.DataContainer")
class DataContainer{
    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read(){
        log.debug("获取读锁...");
        r.lock();
        try {
            log.debug("读取");
            return data;
        }finally {
            log.debug("释放读锁...");
            r.unlock();
        }
    }

    public void write(){
        log.debug("获取写锁...");
        w.lock();
        try {
            log.debug("写入");
        }finally {
            log.debug("释放写锁...");
            w.unlock();
        }
    }
}

