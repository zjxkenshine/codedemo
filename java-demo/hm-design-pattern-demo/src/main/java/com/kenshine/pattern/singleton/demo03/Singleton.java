package com.kenshine.pattern.singleton.demo03;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description:
 *
 *      懒汉式
 * @Author: 黑马程序员
 *
 *
 * 懒汉式：类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建
 * 懒汉式-方式1（线程不安全）
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //声明Singleton类型的变量instance
    private static Singleton instance; //只是声明一个该类型的变量，并没有进行赋值

    //对外提供访问方式
    public static synchronized Singleton getInstance() {
        //判断instance是否为null，如果为null，说明还没有创建Singleton类的对象
        //如果没有，创建一个并返回，如果有，直接返回
        if(instance == null) {
            //线程1等待，线程2获取到cpu的执行权，也会进入到该判断里面
            instance = new Singleton();
        }
        return instance;
    }
}
