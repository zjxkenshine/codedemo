package com.kenshine.kilim.demo02;

import kilim.Pausable;
import kilim.Task;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 9:55
 * @description：示例
 * @modified By：
 * @version: $
 *
 * 定时计数
 */
public class TimerBlast extends Task{
    static AtomicInteger cnt = new AtomicInteger();


    public static class Tick extends Task {
        public void dive(int depth) throws Pausable {
            if (depth==0) Task.sleep(200);
            else dive(depth-1);
        }
        public void execute() throws Pausable {
            for (long ii=0, t1=0, t2=0; ii < 30; ii++, t1=t2) {
                dive(30);
                System.out.println("hello world");
            }
        }

    }

    public static void main(String[] args) throws Exception {
        if (kilim.tools.Kilim.trampoline(false,args)) return;

        int num = 1000;

        for (int ii=0; ii < 10; ii++) new TimerBlast().start();
        Thread.sleep(200);
        new Tick().start();
        Thread.sleep(190);
        for (int ii=0; ii < num; ii++) new TimerBlast().start();

        for (int ii=0; ii < 30; ii++) {
            System.out.println("...");
            Thread.sleep(200);
        }


        idledown();
        System.out.println(cnt.get());
    }

    public void execute() throws Pausable {
        Task.sleep(4000);
        cnt.incrementAndGet();
    }
}
