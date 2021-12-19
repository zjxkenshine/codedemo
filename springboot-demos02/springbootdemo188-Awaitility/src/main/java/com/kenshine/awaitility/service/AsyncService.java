package com.kenshine.awaitility.service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/19 21:08
 * @description：异步服务
 * @modified By：
 * @version: $
 */
public class AsyncService {
    private final int DELAY = 1000;
    //两秒初始化
    private final int INIT_DELAY = 2000;

    private AtomicLong value = new AtomicLong(0);
    //线程池
    private Executor executor = Executors.newFixedThreadPool(4);
    private volatile boolean initialized = false;

    private volatile AtomicBoolean atomicInit = new AtomicBoolean(false);


    /**
     * 初始化
     */
    public void initialize() {
        executor.execute(() -> {
            //模拟初始化需要的时间
            sleep(INIT_DELAY);
            System.out.println("初始化完成");
            initialized = true;
            atomicInit.set(true);
        });
    }

    /**
     * 是否初始化
     * @return
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * 是否初始化 返回原子布尔型
     * @return
     */
    public AtomicBoolean isInitializedAtomic() {
        return atomicInit;
    }


    /**
     * 添加值
     * @param val
     */
    public void addValue(long val) {
        //是否初始化
        throwIfNotInitialized();
        executor.execute(() -> {
            //模拟添加延迟
            sleep(DELAY);
            value.addAndGet(val);
        });
    }

    /**
     * 获取值
     * @return
     */
    public long getValue() {
        throwIfNotInitialized();
        return value.longValue();
    }

    /**
     * 停止线程
     * @param delay
     */
    private void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 是否初始化
     */
    private void throwIfNotInitialized() {
        if (!initialized) {
            throw new IllegalStateException("Service is not initialized");
        }
    }
}
