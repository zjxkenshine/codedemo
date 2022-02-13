package com.kenshine.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

import static com.kenshine.chapter02.util.Sleeper.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 14:36
 * @description：Semaphore 信号量的使用
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.Semaphore")
public class Test05_Semaphore {
    public static void main(String[] args) {
        // 1.创建 Semaphore 对象
        Semaphore semaphore = new Semaphore(3);

        // 2.10个线程同时运行
        for(int i=0;i<10;i++){
            new Thread(()->{
                try {
                    // 获得许可
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    log.debug("running...");
                    sleep(1);
                    log.debug("end...");
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }

}
