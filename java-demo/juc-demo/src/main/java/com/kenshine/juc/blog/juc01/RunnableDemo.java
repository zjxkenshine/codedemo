package com.kenshine.juc.blog.juc01;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 23:50
 * @description：Runnable创建线程
 * @modified By：
 * @version: $
 */
public class RunnableDemo {
    public static void main(String[] args) {
        //4.创建Runnable的子类对象
        MyRunnable mr=new MyRunnable();
        //5.将子类对象当做参数传递给Thread的构造函数,并开启线程
        //MyRunnale taget=mr; 多态
        new Thread(mr).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是主线程"+i);
        }

    }
}

//1.定义一个类实现Runnable
class MyRunnable implements Runnable{
    //2.重写run方法
    @Override
    public void run() {
        //3.将要执行的代码写在run方法中
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是线程"+i);
        }
    }
}
