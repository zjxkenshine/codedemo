package com.kenshine.junitperf.report;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;

/**
 * 默认reporter 控制台
 */
public class DefaultReporterTest {

    @JunitPerfConfig(duration = 1000)
    public void helloTest() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Hello Junit5");
    }

}