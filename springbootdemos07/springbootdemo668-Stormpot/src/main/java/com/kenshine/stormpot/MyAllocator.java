package com.kenshine.stormpot;

import stormpot.Allocator;
import stormpot.Slot;

/**
 * @author by kenshine
 * @Classname MyAllocator
 * @Description 分配器
 * @Date 2024-01-10 16:13
 * @modified By：
 * @version: 1.0$
 */
public class MyAllocator implements Allocator<MyPoolable> {
    /**
     * 分配对象
     */
    @Override
    public MyPoolable allocate(Slot slot) throws Exception {
        MyPoolable myPoolable = new MyPoolable(slot);
        return myPoolable;
    }

    @Override
    public void deallocate(MyPoolable myPoolable) throws Exception {
        // 取消分配给定的Poolable并释放与其相关的任何资源
    }
}
