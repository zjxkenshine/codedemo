package com.kenshine.okhttp.listener;

import okhttp3.Call;
import okhttp3.EventListener;

import java.net.InetAddress;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 10:46
 * @description：自定义监听器
 * @modified By：
 * @version: $
 */
public class CustomEventListener extends EventListener {
    private long callStartNanos;

    private void printEvent(String name) {
        //当前时间
        long nowNanos = System.nanoTime();
        if (name.equals("callStart")) {
            callStartNanos = nowNanos;
        }
        long elapsedNanos = nowNanos - callStartNanos;
        System.out.printf("%.3f %s%n", elapsedNanos / 1000000000d, name);
    }

    @Override public void callStart(Call call) {
        printEvent("callStart");
    }

    @Override public void callEnd(Call call) {
        printEvent("callEnd");
    }

    @Override public void dnsStart(Call call, String domainName) {
        printEvent("dnsStart");
    }

    @Override public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        printEvent("dnsEnd");
    }
}
