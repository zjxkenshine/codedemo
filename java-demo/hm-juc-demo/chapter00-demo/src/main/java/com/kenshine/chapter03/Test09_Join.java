package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/4 21:43
 * @description：
 * @modified By：
 * @version: $
 * join 用于等待某个线程结束。哪个线程内调用 join () 方法，就等待哪个线程结束，然后再去执行其他线程
 */
@Slf4j(topic = "c.TestJoin")
public class Test09_Join {
    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        test1();
    }
    private static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            r = 10;
        });
        t1.start();
        // 主线程等待t1线程结束
        t1.join();
        log.debug("结果为:{}", r);
        log.debug("结束");
    }


}
