package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/9 21:44
 * @description：
 * @modified By：
 * @version: $
 */
// -XX:-UseCompressedOops -XX:-UseCompressedClassPointers -XX:BiasedLockingStartupDelay=0 -XX:+PrintFlagsFinal
//-XX:-UseBiasedLocking 禁用偏向锁 tid=0x000000001f173000  -XX:BiasedLockingStartupDelay=0 -XX:+TraceBiasedLocking
@Slf4j(topic = "c.TestBiased")
public class Test05_Biased {
    /*
   [t1] - 29	00000000 00000000 00000000 00000000 00011111 01000101 01101000 00000101
   [t2] - 29	00000000 00000000 00000000 00000000 00011111 01000101 11000001 00000101
    */
    public static void main(String[] args) throws InterruptedException {
        // 测试偏向锁延时特性
        test1();
        // 测试撤销偏向锁
        test2();
        // 批量重偏向
        test3();
        //批量撤销
        test4();
    }

    private static void test5() throws InterruptedException {

        log.debug("begin");
        for (int i = 0; i < 6; i++) {
            Dog d = new Dog();
            log.debug(ClassLayout.parseInstance(d).toPrintable());
            Thread.sleep(1000);
        }
    }

    static Thread t1, t2, t3;

    private static void test4() throws InterruptedException {
        Vector<Dog> list = new Vector<>();

        int loopNumber = 39;
        t1 = new Thread(() -> {
            for (int i = 0; i < loopNumber; i++) {
                Dog d = new Dog();
                list.add(d);
                synchronized (d) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                }
            }
            LockSupport.unpark(t2);
        }, "t1");
        t1.start();

        t2 = new Thread(() -> {
            LockSupport.park();
            log.debug("===============> ");
            for (int i = 0; i < loopNumber; i++) {
                Dog d = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
            }
            LockSupport.unpark(t3);
        }, "t2");
        t2.start();

        t3 = new Thread(() -> {
            LockSupport.park();
            log.debug("===============> ");
            for (int i = 0; i < loopNumber; i++) {
                Dog d = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
            }
        }, "t3");
        t3.start();

        t3.join();
        log.debug(ClassLayout.parseInstance(new Dog()).toPrintable());
    }

    private static void test3() throws InterruptedException {

        Vector<Dog> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                Dog d = new Dog();
                list.add(d);
                synchronized (d) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                }
            }
            synchronized (list) {
                list.notify();
            }
        }, "t1");
        t1.start();


        Thread t2 = new Thread(() -> {
            synchronized (list) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("===============> ");
            for (int i = 0; i < 30; i++) {
                Dog d = list.get(i);
                log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                synchronized (d) {
                    log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
                }
                log.debug(i + "\t" + ClassLayout.parseInstance(d).toPrintable());
            }
        }, "t2");
        t2.start();
    }

    // 测试撤销偏向锁 情况二
    // 其他线程使用
    private static void test2() throws InterruptedException {

        Dog d = new Dog();
        Thread t1 = new Thread(() -> {
            synchronized (d) {
                log.debug(ClassLayout.parseInstance(d).toPrintable());
            }
            synchronized (Test05_Biased.class) {
                Test05_Biased.class.notify();
            }
        }, "t1");
        t1.start();


        Thread t2 = new Thread(() -> {
            synchronized (Test05_Biased.class) {
                try {
                    Test05_Biased.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug(ClassLayout.parseInstance(d).toPrintable());
            synchronized (d) {
                log.debug(ClassLayout.parseInstance(d).toPrintable());
            }
            log.debug(ClassLayout.parseInstance(d).toPrintable());
        }, "t2");
        t2.start();
    }



    // 测试偏向锁
    private static void test1() {
        Dog d = new Dog();
        // hashcode会使偏向锁失效
        // d.hashCode();
        log.debug(ClassLayout.parseInstance(d).toPrintable());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug(ClassLayout.parseInstance(new Dog()).toPrintable());
    }
}
class Dog {
}
