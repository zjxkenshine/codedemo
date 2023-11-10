package com.kenshine.junitperf.report;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;

/**
 * Html 报告
 * 生成的报告在target目录中
 */
public class HtmlReporterTest {
    @JunitPerfConfig(duration = 1000, reporter = {HtmlReporter.class})
    public void helloTest() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Hello Junit5");
    }
}