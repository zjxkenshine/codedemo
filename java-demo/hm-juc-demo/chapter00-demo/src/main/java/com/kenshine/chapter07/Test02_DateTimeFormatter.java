package com.kenshine.chapter07;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 10:27
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j(topic = "c.DateTimeFormatter")
public class Test02_DateTimeFormatter {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LocalDate date = dtf.parse("2018-10-01", LocalDate::from);
                log.debug("{}", date);
            }).start();
        }
    }
}
