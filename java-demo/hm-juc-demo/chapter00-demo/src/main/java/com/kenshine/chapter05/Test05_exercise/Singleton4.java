package com.kenshine.chapter05.Test05_exercise;

/**
 * DCL 懒汉式
 */
public final class Singleton4 {
    private Singleton4() { }
    // 问题1：解释为什么要加 volatile ?为了防止重排序问题
    private static volatile Singleton4 INSTANCE = null;

    // 问题2：对比实现3, 说出这样做的意义：提高了效率
    public static Singleton4 getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (Singleton4.class) {
            // 问题3：为什么还要在这里加为空判断, 之前不是判断过了吗？这是为了第一次判断时的并发问题。
            if (INSTANCE != null) { // t2
                return INSTANCE;
            }
            INSTANCE = new Singleton4();
            return INSTANCE;
        }
    }
}