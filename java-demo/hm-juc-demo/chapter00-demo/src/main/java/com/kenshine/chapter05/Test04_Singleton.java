package com.kenshine.chapter05;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 17:51
 * @description：DCL双重检查锁定
 * @modified By：
 * @version: $
 */
public class Test04_Singleton {
}

// 单例模式
class Singleton{
    private Singleton() {
    }
    private static volatile Singleton INSTANCE = null;

    public static Singleton getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (Singleton.class) {
            // 也许有其它线程已经创建实例，所以再判断一次
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
            return INSTANCE;
        }
    }
}
