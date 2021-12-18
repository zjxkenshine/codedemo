package com.kenshine.okhttp.listener;

import okhttp3.Call;
import okhttp3.EventListener;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 10:58
 * @description：事件工厂
 * @modified By：
 * @version: $
 */
public class CustomFactoryEventListener extends EventListener{
    public static final Factory FACTORY = new Factory() {
        final AtomicLong nextCallId = new AtomicLong(1L);

        @Override public EventListener create(Call call) {
            long callId = nextCallId.getAndIncrement();
            System.out.printf("%04d %s%n", callId, call.request().url());
            //设置一个调用Id
            return new CustomFactoryEventListener(callId, System.nanoTime());
        }
    };

    final long callId;
    final long callStartNanos;

    public CustomFactoryEventListener(long callId, long callStartNanos) {
        this.callId = callId;
        this.callStartNanos = callStartNanos;
    }

    private void printEvent(String name) {
        long elapsedNanos = System.nanoTime() - callStartNanos;
        System.out.printf("%04d %.3f %s%n", callId, elapsedNanos / 1000000000d, name);
    }

    @Override public void callStart(Call call) {
        printEvent("callStart");
    }

    @Override public void callEnd(Call call) {
        printEvent("callEnd");
    }

    //其他方法
}
