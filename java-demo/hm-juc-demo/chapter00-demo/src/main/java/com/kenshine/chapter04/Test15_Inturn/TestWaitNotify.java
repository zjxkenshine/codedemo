package com.kenshine.chapter04.Test15_Inturn;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 12:40
 * @description：交替输出模式 Wait/Notify实现
 * @modified By：
 * @version: $
 */
public class TestWaitNotify {
    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify(1, 5);

        new Thread(()->{
            waitAndNotify.run("a", 1, 2);
        }).start();
        new Thread(()->{
            waitAndNotify.run("b", 2, 3);
        }).start();
        new Thread(()->{
            waitAndNotify.run("c", 3, 1);
        }).start();
    }
}

class WaitAndNotify {
    public void run(String str, int flag, int nextFlag) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (flag != this.flag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                // 设置下一个运行的线程标记
                this.flag = nextFlag;
                // 唤醒所有线程
                this.notifyAll();
            }
        }
    }

    private int flag;
    private int loopNumber;
    public WaitAndNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }
}