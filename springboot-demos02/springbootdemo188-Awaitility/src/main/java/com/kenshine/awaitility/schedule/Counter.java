package com.kenshine.awaitility.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/19 22:00
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class Counter {
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * 每100ms加1
     */
    @Scheduled(fixedDelay = 100)
    public void scheduled() {
        this.count.incrementAndGet();
    }

    public int getInvocationCount() {
        return this.count.get();
    }
}
