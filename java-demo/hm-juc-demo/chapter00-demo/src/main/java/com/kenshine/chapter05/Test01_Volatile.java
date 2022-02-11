package com.kenshine.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 14:08
 * @description：volatile的使用
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.Volatile")
public class Test01_Volatile {
    // 添加volatile后
    public static volatile boolean run = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(run) {
            }
        }, "t1");

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("t1 Stop");
        // 设置run t1线程也不会停止，t1线程会从工作内存中读取run值
        run = false;
    }
}
