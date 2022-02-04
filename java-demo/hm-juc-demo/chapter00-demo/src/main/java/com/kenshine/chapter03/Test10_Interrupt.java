package com.kenshine.chapter03;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;
import static com.kenshine.chapter02.util.Sleeper.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/4 22:08
 * @description：
 * @modified By：
 * @version: $
 * isInterrupted 是实例方法，interrupted 是静态方法，它们的用处都是查看当前打断的状态
 * - isInterrupted 方法查看线程的时候，不会将打断标记清空，也就是置为 false，
 * - interrupted 查看线程打断状态后，会将打断标志置为 false，也就是清空打断标记
 */
@Slf4j(topic = "c.TestInterrupt")
public class Test10_Interrupt {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }
    private static void test4() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log.debug("park...");
                LockSupport.park();
                log.debug("打断状态：{}", Thread.interrupted());
            }
        });
        t1.start();
        sleep(1);
        t1.interrupt();
    }
    private static void test3() {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        sleep(0.5);
        t1.interrupt();
    }
    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(()->{
            while(true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if(interrupted) {
                    log.debug(" 打断状态: {}", interrupted);
                    break;
                }
            }
        }, "t2");
        t2.start();
        sleep(0.5);
        t2.interrupt();
    }
    private static void test1(){
        Thread t1 = new Thread(()->{
            sleep(1);
        }, "t1");
        t1.start();
        sleep(0.5);
        t1.interrupt();
        log.debug(" 打断状态: {}", t1.isInterrupted());
    }
}
