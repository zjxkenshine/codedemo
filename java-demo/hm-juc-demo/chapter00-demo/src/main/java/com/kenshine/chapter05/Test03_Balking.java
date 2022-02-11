package com.kenshine.chapter05;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 15:02
 * @description：犹豫模式测试
 * @modified By：
 * @version: $
 */
public class Test03_Balking {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        monitor.start();
        monitor.start();
        Thread.sleep(3500);
        monitor.stop();
    }
}

class Monitor {
    Thread monitor;
    private volatile boolean stop = false;
    private boolean starting = false;

    public void start() {
        synchronized (this) {
            if (starting) {
                return;
            }
            starting = true;
        }
        monitor = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (stop) {
                        System.out.println("处理后续任务");
                        break;
                    }
                    System.out.println("监控运行中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("被打断了");
                    }
                }
            }
        };
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
        stop = true;
    }
}
