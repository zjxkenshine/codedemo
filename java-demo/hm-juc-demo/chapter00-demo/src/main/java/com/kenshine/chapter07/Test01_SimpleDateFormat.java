package com.kenshine.chapter07;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 10:22
 * @description：SimpleDateFormat多线程问题
 * @modified By：
 * @version: $
 * SimpleDateFormat 不是线程安全的，有很大几率出现 java.lang.NumberFormatException 或者出现不正确的日期解析结果
 */
@Slf4j(topic = "c.simpleDateFormat")
public class Test01_SimpleDateFormat {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    log.debug("{}", sdf.parse("1951-04-21"));
                } catch (Exception e) {
                    log.error("{}", e);
                }
            }).start();
        }
    }
}
