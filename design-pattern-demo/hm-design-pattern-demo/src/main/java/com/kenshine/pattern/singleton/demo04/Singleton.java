package com.kenshine.pattern.singleton.demo04;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: 双重检查锁方式
 * @Author: 黑马程序员
 *
 *
 * 懒汉式-方式2（线程安全） 加volatile关键字 同步创建方法
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //声明为Volatile
    private static volatile Singleton instance;

    //对外提供公共的访问方式
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
