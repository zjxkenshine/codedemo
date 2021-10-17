package com.kenshine.pattern.singleton.demo02;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description:
 *
 *      饿汉式 ： 静态代码块
 * @Author: 黑马程序员
 *
 *
 * 饿汉式-方式2（静态代码块方式）
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //声明Singleton类型的变量
    private static Singleton instance; //null

    //在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    //对外提供获取该类对象的方法
    public static Singleton getInstance() {
        return instance;
    }
}
