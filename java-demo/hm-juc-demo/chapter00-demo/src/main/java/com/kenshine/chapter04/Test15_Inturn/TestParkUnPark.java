package com.kenshine.chapter04.Test15_Inturn;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 12:48
 * @description：交替输出模式 LockSupport park/unpark实现
 * @modified By：
 * @version: $
 */
public class TestParkUnPark {
    public static Thread t1, t2, t3;
    public static void main(String[] args) {
        // 每个线程循环5次
        ParkAndUnPark obj = new ParkAndUnPark(5);
        t1 = new Thread(() -> {
            obj.run("a", t2);
        });
        t2 = new Thread(() -> {
            obj.run("b", t3);
        });
        t3 = new Thread(() -> {
            obj.run("c", t1);
        });
        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t1);
    }
}

class ParkAndUnPark {
    public void run(String str, Thread nextThread) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(nextThread);
        }
    }
    // 循环次数
    private int loopNumber;
    public ParkAndUnPark(int loopNumber) {
        this.loopNumber = loopNumber;
    }
}
