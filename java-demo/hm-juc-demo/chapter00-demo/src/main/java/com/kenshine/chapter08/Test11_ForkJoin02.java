package com.kenshine.chapter08;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 18:45
 * @description：
 * @modified By：
 * @version: $
 */
public class Test11_ForkJoin02 {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println(pool.invoke(new MyTask(5)));
        // new MyTask(5)  5+ new MyTask(4)  4 + new MyTask(3)  3 + new MyTask(2)  2 + new MyTask(1)
    }
}

// 1~n 之间整数的和
@Slf4j(topic = "c.MyTask")
class MyTask extends RecursiveTask<Integer> {
    private int n;

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "{" + n + '}';
    }

    @Override
    protected Integer compute() {
        // 如果 n 已经为 1，可以求得结果了
        if (n == 1) {
            log.debug("join() {}", n);
            return n;
        }

        // 将任务进行拆分(fork) 开始执行
        AddTask1 t1 = new AddTask1(n - 1);
        t1.fork();
        log.debug("fork() {} + {}", n, t1);

        // 合并(join)结果 等待执行结果
        int result = n + t1.join();
        log.debug("join() {} + {} = {}", n, t1, result);
        return result;
    }
}