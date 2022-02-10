package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/10 21:19
 * @description：LockSupport ParkUnPark方法
 * @modified By：
 * @version: $
 *
 * wait，notify 和 notifyAll 必须配合 Object Monitor 一起使用，而 park，unpark 不必；
 * park & unpark 是以线程为单位来【阻塞】和【唤醒】线程，而 notify 只能随机唤醒一个等待线程，notifyAll 是唤醒所有等待线程，就不那么【精确】
 * park & unpark 可以先 unpark，而 wait & notify 不能先 notify。
 */
@Slf4j(topic = "c.TestParkUnpark")
public class Test10_LockSupport {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(() -> {
            log.debug("start...");
            try {
                Thread.sleep(1000);
                log.debug("park...");
                LockSupport.park();
                log.debug("resume..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        Thread.sleep(2000);
        log.debug("unpark...");
        LockSupport.unpark(t1);
    }
}
