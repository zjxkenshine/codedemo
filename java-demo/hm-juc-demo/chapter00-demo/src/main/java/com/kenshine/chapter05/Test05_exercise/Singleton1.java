package com.kenshine.chapter05.Test05_exercise;

import java.io.Serializable;

/**
 * 饿汉式
 */
// 问题1：为什么加 final，防止子类继承后更改
// 问题2：如果实现了序列化接口, 还要做什么来防止反序列化破坏单例，如果进行反序列化的时候会生成新的对象，这样跟单例模式生成的对象是不同的。要解决直接加上readResolve()方法就行了，如下所示
public final class Singleton1 implements Serializable {
    // 问题3：为什么设置为私有? 防止其它类中使用new生成新的实例，是否能防止反射创建新的实例?不能。
    private Singleton1() {}
    // 问题4：这样初始化是否能保证单例对象创建时的线程安全?没有，这是类变量，是jvm在类加载阶段就进行了初始化，jvm保证了此操作的线程安全性
    private static final Singleton1 INSTANCE = new Singleton1();
    // 问题5：为什么提供静态方法而不是直接将 INSTANCE 设置为 public, 说出你知道的理由。
    //1.提供更好的封装性；2.提供范型的支持
    public static Singleton1 getInstance() {
        return INSTANCE;
    }
    // 保证序列化返回的也是单例对象
    public Object readResolve() {
        return INSTANCE;
    }
}