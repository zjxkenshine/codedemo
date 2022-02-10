package com.kenshine.chapter04;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/10 12:43
 * @description：保护性暂停
 * @modified By：
 * @version: $
 */
@Slf4j(topic ="c.GuardedObject")
public class Test07_GuardedObject {
    private Object response;
    private final Object lock = new Object();

    public Object get(long timeout) {
        synchronized (lock) {
            long begin = System.currentTimeMillis();
            long timePassed = 0;
            while (response == null) {
                // 这轮循环应该等待的时间
                long waitTime = timeout - timePassed;
                log.debug("waitTime: {}", waitTime);
                if (waitTime <= 0) {
                    log.debug("break..");
                    break;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 经历时长
                timePassed=System.currentTimeMillis()-begin;
                log.debug("timePassed: {}, object is null {}", timePassed, response == null);
            }
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            this.response = response;
            log.debug("notify..");
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        Test07_GuardedObject v2 = new Test07_GuardedObject();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 设置结果为null
            v2.complete(null);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 设置结果为list
            v2.complete(Arrays.asList("a", "b", "c"));
        },"t1").start();

        Object response = v2.get(1500);
        if (response != null) {
            log.debug("get response: [{}] lines", ((List<String>) response).size());
        } else {
            log.debug("can't get response");
        }
    }
}
