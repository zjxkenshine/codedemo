package com.kenshine.pattern.singleton.demo06;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/17 13:16
 * @description：懒汉式-静态内部类方式
 * @modified By：
 * @version: 1.0$
 */
/**
 * 懒汉式-静态内部类方式
 * 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }


}