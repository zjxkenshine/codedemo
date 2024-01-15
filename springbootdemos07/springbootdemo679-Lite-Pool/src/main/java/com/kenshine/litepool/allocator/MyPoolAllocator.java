package com.kenshine.litepool.allocator;

import cn.nextop.lite.pool.Pool;
import cn.nextop.lite.pool.support.PoolAllocator;
import cn.nextop.lite.pool.support.PoolAllocatorFactory;
import cn.nextop.lite.pool.support.allocator.AbstractAllocator;

import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname MyPoolAllocator
 * @Description 自定义分配器
 * @Date 2024-01-15 8:54
 * @modified By：
 * @version: 1.0$
 *
 */
public class MyPoolAllocator<T> extends AbstractAllocator<T> {

    public MyPoolAllocator(Pool<T> pool, String name) {
        super(pool, name);
    }

    @Override
    protected Slot<T> doRelease(T t) {
        return null;
    }

    @Override
    protected Slot<T> doAcquire(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public int getIdleCount() {
        return 0;
    }

    @Override
    public int getBusyCount() {
        return 0;
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public int getPendingCount() {
        return 0;
    }

    public static class Factory<T> implements PoolAllocatorFactory<T> {
        @Override public final PoolAllocator<T> create(final Pool<T> v) {
            String n = v.getName() + ".allocator.your.name"; return new MyPoolAllocator<>(v, n);
        }
    }
}
