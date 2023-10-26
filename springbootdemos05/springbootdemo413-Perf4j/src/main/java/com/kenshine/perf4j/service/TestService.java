package com.kenshine.perf4j.service;

import org.junit.Test;
import org.perf4j.StopWatch;
import org.perf4j.aop.Profiled;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.springframework.stereotype.Service;

/**
 * @author by kenshine
 * @Classname TestService
 * @Description 测试
 * @Date 2023-10-26 11:50
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TestService {

    @Profiled(tag="method03")
    public void test01(){
        StopWatch stopWatch = new Slf4JStopWatch();
        System.out.println("test03调用");
        stopWatch.stop("test03","耗时");
    }
}
