package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 18:04
 * @description： 使用Future，错误信息都被封装进submit方法的返回方法中
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.Exception02")
public class Test09_Exception02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<Boolean> f = pool.submit(() -> {
            log.debug("task1");
            int i = 1 / 0;
            return true;
        });
        log.debug("result:{}", f.get());
    }
}
