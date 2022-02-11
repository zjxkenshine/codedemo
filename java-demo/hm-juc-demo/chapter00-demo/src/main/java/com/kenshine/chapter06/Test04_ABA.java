package com.kenshine.chapter06;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 20:31
 * @description：ABA问题
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.ABA")
public class Test04_ABA {
    public static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {
        log.debug("main start...");
        String preVal = ref.get();
        // ABA操作
        other();
        TimeUnit.SECONDS.sleep(1);
        log.debug("change A->C {}", ref.compareAndSet(preVal, "C"));
    }

    private static void other() throws InterruptedException {

        new Thread(() -> {
            log.debug("change A->B {}", ref.compareAndSet(ref.get(), "B"));
        }, "t1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            log.debug("change B->A {}", ref.compareAndSet(ref.get(), "A"));
        }, "t2").start();
    }
}
