package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 15:16
 * @description：SynchronousQueue 队列测试
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.SynchronousQueue")
public class Test03_SynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        //SynchronousQueue没有容量，消费者获取则生产者会阻塞
        SynchronousQueue<Integer> integers = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                log.debug("putting {} ", 1);
                integers.put(1);
                log.debug("{} putted...", 1);
                log.debug("putting...{} ", 2);
                integers.put(2);
                log.debug("{} putted...", 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t1").start();

        Thread.sleep(1000);
        new Thread(() -> {
            try {
                log.debug("taking {}",1);
                integers.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

        Thread.sleep(1000);
        new Thread(() -> {
            try {
                log.debug("taking {}",2);
                integers.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();
    }
}
