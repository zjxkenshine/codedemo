package com.kenshine.junitperf.report;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;

/**
 * 自定义输出
 */
public class DefineReporterTest {

    @JunitPerfConfig(duration = 1000, reporter = MyReporter.class)
    public void helloTest() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Hello Junit5");
    }

}