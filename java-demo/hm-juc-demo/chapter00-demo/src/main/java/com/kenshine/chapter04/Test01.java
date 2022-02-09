package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/9 10:47
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j(topic="c.test01")
public class Test01 {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1;i < 5000; i++){
                count++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1;i < 5000; i++){
                count--;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("count的值是{}",count);
    }
}
