package com.kenshine.stormpot;

import stormpot.Pool;
import stormpot.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname Stormpot
 * @Description Stormpot使用测试
 * @Date 2024-01-10 16:06
 * @modified By：
 * @version: 1.0$
 */
public class StormpotTest {

    public static void main(String[] args) throws InterruptedException {
        MyAllocator allocator = new MyAllocator();
        Pool<MyPoolable> pool = Pool.from(allocator).build();
        Timeout timeout = new Timeout(1, TimeUnit.SECONDS);
        Long managed=pool.getManagedPool().getAllocationCount();
        System.out.println(managed);
        MyPoolable poolable= pool.getThreadLocalTap().claim(timeout);
        System.out.println(poolable);
    }

}
