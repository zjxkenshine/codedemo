package com.kenshine.perf4j;

import org.junit.Test;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;
import org.perf4j.aop.Profiled;
import org.perf4j.slf4j.Slf4JStopWatch;

/**
 * @author by kenshine
 * @Classname TestStopWatch
 * @Description StopWatch方法
 * @Date 2023-10-26 11:30
 * @modified By：
 * @version: 1.0$
 */
public class TestStopWatch {
    @Test
    public void test01(){
        StopWatch stopWatch = new LoggingStopWatch();
        System.out.println("test01调用");
        stopWatch.stop("test01","耗时");
    }

    /**
     * Slf4J日志 不用其他配置
     */
    @Test
    public void test02(){
        StopWatch stopWatch = new Slf4JStopWatch();
        System.out.println("test02调用");
        stopWatch.stop("test02","耗时");
    }

    @Profiled(tag="method03")
    @Test
    public void test03(){
        StopWatch stopWatch = new Slf4JStopWatch();
        System.out.println("test03调用");
        stopWatch.stop("test03","耗时");
    }

}
