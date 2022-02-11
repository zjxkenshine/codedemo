package com.kenshine.chapter05.Test05_exercise;

/**
 * 静态内部类懒汉式
 */
public final class Singleton5 {
    private Singleton5() { }
    // 问题1：属于懒汉式还是饿汉式：懒汉式，这是一个静态内部类。类加载本身就是懒惰的，在没有调用getInstance方法时是没有执行       //LazyHolder内部类的类加载操作的。
    private static class LazyHolder {
        static final Singleton5 INSTANCE = new Singleton5();
    }
    // 问题2：在创建时是否有并发问题，这是线程安全的，类加载时，jvm保证类加载操作的线程安全
    public static Singleton5 getInstance() {
        return LazyHolder.INSTANCE;
    }
}