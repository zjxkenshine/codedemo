package com.kenshine.chapter04.Test15_Order;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 12:16
 * @description： 顺序控制 WaitNotify实现
 * @modified By：
 * @version: $
 */
public class TestWaitNotify {
    // 用来同步的对象
    static Object obj = new Object();
    // t2 运行标记， 代表 t2 是否执行过
    static boolean t2runed = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                // 如果 t2 没有执行过
                while (!t2runed) {
                    try {
                        // t1 先等一会
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(1);
        });
        Thread t2 = new Thread(() -> {
            System.out.println(2);
            synchronized (obj) {
                // 修改运行标记
                t2runed = true;
                // 通知 obj 上等待的线程（可能有多个，因此需要用 notifyAll）
                obj.notifyAll();
            }
        });
        t1.start();
        t2.start();
    }
}

