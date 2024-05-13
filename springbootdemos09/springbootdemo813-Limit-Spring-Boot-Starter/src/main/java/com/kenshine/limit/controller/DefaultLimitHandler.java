package com.kenshine.limit.controller;

import idea.verlif.spring.limit.LimitHandler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kenshine
 * 默认限流处理器
 */
@Component
@EnableScheduling
public class DefaultLimitHandler implements LimitHandler {

    /**
     * 单位时间内的可访问次数
     */
    private static final Integer COUNT_PER = 10;

    private final Map<String, Integer> countMap;

    public DefaultLimitHandler() {
        countMap = new ConcurrentHashMap<>();
    }

    @Override
    public boolean arrived(String key) {
        int count = getCount(key);
        if (count > 0) {
            consume(key);
            return true;
        }
        return false;
    }

    private int getCount(String key) {
        Integer count = countMap.get(key);
        return count == null ? COUNT_PER : count;
    }

    private void consume(String key) {
        countMap.put(key, getCount(key) - 1);
    }

    /**
     * 设置刷新时间间隔
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    private synchronized void reset() {
        countMap.replaceAll((k, v) -> COUNT_PER);
    }
}