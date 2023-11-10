package com.kenshine.junitperf.test;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;

/**
 * @author by kenshine
 * @Classname HelloWorldTest
 * @Description 测试
 * @Date 2023-11-10 16:59
 * @modified By：
 * @version: 1.0$
 */
public class HelloWorldTest {

    @JunitPerfConfig(duration = 1000)
    public void helloTest() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Hello Junit5");
    }
}
