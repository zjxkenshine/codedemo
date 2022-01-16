package com.kenshine.webflux.reactor8;

import java.util.Observable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 20:38
 * @description：
 * @modified By：
 * @version: $
 * java8 使用观察者模式进行响应式编程
 * java9 使用Flow进行响应式编程
 */
public class ObserverDemo extends Observable {
    public static void main(String[] args) {
        //添加观察者
        ObserverDemo observerDemo = new ObserverDemo();
        observerDemo.addObserver((o,arg)->{
            System.out.println("发生变化");
        });

        observerDemo.addObserver((o,arg)->{
            System.out.println("手动被观察者通知,准备改变");
        });

        observerDemo.setChanged();//数据变化
        observerDemo.notifyObservers();//通知观察者
    }
}
