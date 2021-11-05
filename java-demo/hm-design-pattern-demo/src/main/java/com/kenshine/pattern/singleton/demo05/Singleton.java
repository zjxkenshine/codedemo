package com.kenshine.pattern.singleton.demo05;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: 双重检查锁方式
 * @Author: 黑马程序员
 *
 * 懒汉式-方式3（双重检查锁）
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    /**
     * 需要volatile关键字，否则可能会因为指令重排序导致空指针
     */
    private static volatile Singleton instance;

    //对外提供公共的访问方式
    public static Singleton getInstance() {
        //第一次判断，如果instance的值不为null，不需要抢占锁，直接返回对象
        if(instance == null) {
            synchronized (Singleton.class) {
                //第二次判断
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
