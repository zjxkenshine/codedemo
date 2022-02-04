package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/1 11:03
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
public class Test03_Create_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 实现多线程的第三种方法可以返回数据
        FutureTask futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("执行多线程任务");
                Thread.sleep(100);
                return 100;
            }
        });
        // 主线程阻塞，同步等待 task 执行完毕的结果
        new Thread(futureTask,"线程t1").start();
        log.debug("主线程");
        log.debug("{}",futureTask.get());
    }
}
