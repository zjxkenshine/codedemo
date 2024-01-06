package com.kenshine.jcip;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 线程安全
 * @author kenshine
 */
@ThreadSafe
public class Sequence {

    /**
     * 受对象内部锁保护
     */
    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {  
        return value++;  
    }  
}