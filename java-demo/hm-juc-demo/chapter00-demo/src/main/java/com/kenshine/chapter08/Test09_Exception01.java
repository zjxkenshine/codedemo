package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 18:02
 * @description：try/catch 代码块处理线程异常
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.Exception01")
public class Test09_Exception01 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(() -> {
            try {
                log.debug("task1");
                int i = 1 / 0;
            } catch (Exception e) {
                log.error("error:", e);
            }
        });
    }
}
