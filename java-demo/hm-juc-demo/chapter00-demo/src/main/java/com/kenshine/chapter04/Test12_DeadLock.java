package com.kenshine.chapter04;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 9:55
 * @description：死锁示例1
 * @modified By：
 * @version: $
 */
public class Test12_DeadLock {
    public static void main(String[] args) {
        final Object A = new Object();
        final Object B = new Object();
        new Thread(()->{
            synchronized (A) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 等待B线程
                synchronized (B) {
                }
            }
        },"t1").start();
        new Thread(()->{
            synchronized (B) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 等待A线程
                synchronized (A) {
                }
            }
        },"t2").start();
    }
}
