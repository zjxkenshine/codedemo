package com.kenshine.juc.blog.juc00;

import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/7 0:09
 * @description：运行中线程数量
 * @modified By：
 * @version: $
 */
public class threadActiveCount {

    public static void main(String[] args) throws InterruptedException {
        //打印当前线程组的线程
        Thread.currentThread().getThreadGroup().list();
        System.out.println("=========");

        //timeUnit类的使用
        TimeUnit.SECONDS.sleep(1);

        //idea2019.3 结果为1
        System.out.println(Thread.activeCount());
    }

}
