package com.kenshine.stormpot;

import stormpot.Poolable;
import stormpot.Slot;

/**
 * @author by kenshine
 * @Classname MyPoolable
 * @Description 池化对象
 * @Date 2024-01-10 16:14
 * @modified By：
 * @version: 1.0$
 */
public class MyPoolable implements Poolable {
    public final Slot slot;
    public Thread lastReleaseBy;

    public MyPoolable(Slot slot) {
        this.slot = slot;
    }
    @Override
    public void release() {
        lastReleaseBy = Thread.currentThread();
        slot.release(this);
    }

    public void expire() {
        slot.expire(this);
    }
}
