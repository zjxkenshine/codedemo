package com.kenshine.pattern.singleton.demo09;


/**
 * @version v1.0
 * @ClassName: Singleton
 * @Description: 静态内部类方式
 * @Author: 黑马程序员
 *
 * 反射破坏单例模式
 * 解决方案： synchronized 代码块判断是否创建
 */
public class Singleton {

    private static boolean flag = false;

    //私有构造方法
    private Singleton() {
        //反射破坏单例模式-解决方案
//        synchronized (Singleton.class) {
//            //判断flag的值是否是true，如果是true，说明非第一次访问，直接抛一个异常，如果是false的话，说明第一次访问
//            if (flag) {
//                throw new RuntimeException("不能创建多个对象");
//            }
//            //将flag的值设置为true
//            flag = true;
//        }
    }

    //定义一个静态内部类
    private static class SingletonHolder {
        //在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供公共的访问方式
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
