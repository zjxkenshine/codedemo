package com.kenshine.junitperf.report;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;

/**
 * 多个reporter
 */
public class MultiReporterTest {

    @JunitPerfConfig(duration = 1000, reporter = {HtmlReporter.class,
            ConsoleReporter.class})
    public void helloTest() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Hello Junit5");
    }

}