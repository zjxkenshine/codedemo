package com.kenshine.juc.blog.juc01;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 23:40
 * @description：Thread方式创建线程
 * @modified By：
 * @version: $
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        //4.创建Thread类的子类对象
        MyThread myThread=new MyThread();
        //5.调用start()方法开启线程
        //[ 会自动调用run方法这是JVM做的事情,源码看不到 ]
        myThread.start();
        for (int i = 0; i < 100; i++) {
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println("我是主线程"+i);
        }
    }

}
class MyThread extends Thread{
    //2.重写run方法

    @SneakyThrows
    public void run(){
        //3.将要执行的代码写在run方法中
        for(int i=0;i<100;i++){
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println("我是线程"+i);
        }
    }
}
