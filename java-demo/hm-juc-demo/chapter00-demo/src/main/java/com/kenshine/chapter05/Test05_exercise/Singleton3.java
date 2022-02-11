package com.kenshine.chapter05.Test05_exercise;

/**
 * 懒汉式
 */
public final class Singleton3 {
    private Singleton3() { }
    private static Singleton3 INSTANCE = null;
    // 分析这里的线程安全, 并说明有什么缺点：synchronized加载静态方法上，可以保证线程安全。缺点就是锁的范围过大，每次访问都会加锁，性能比较低。
    public static synchronized Singleton3 getInstance() {
        if( INSTANCE != null ){
            return INSTANCE;
        }
        INSTANCE = new Singleton3();
        return INSTANCE;
    }
}