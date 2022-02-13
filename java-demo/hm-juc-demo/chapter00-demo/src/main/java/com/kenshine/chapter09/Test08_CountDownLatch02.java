package com.kenshine.chapter09;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 15:34
 * @description：《并发编程的艺术》示例
 * @modified By：
 * @version: $
 */
public class Test08_CountDownLatch02 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count=new CountDownLatch(2); //设置计数器为2

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                count.countDown();	//计数器-1
                System.out.println(2);
                count.countDown();	//计数器再-1
            }
        }).start();

        count.await();	//计数器不为0，当前线程会一直等待
        System.out.println(3);
    }
}
