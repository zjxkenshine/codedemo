package com.kenshine.easyretry.service;

import com.aizuda.easy.retry.client.core.annotation.Retryable;
import com.kenshine.easyretry.exception.ParamException;
import org.springframework.stereotype.Component;

/**
 * @author kenshine
 * 重试测试
 */
@Component
public class LocalRetryService {

    @Retryable(scene = "localRetry")
    public void localRetry(){
        System.out.println("local retry 方法开始执行");
        double i = 1 / 0;
    }

    /**
     *  这个函数里面我们设置重试次数为4，每次间隔10s
     */
    @Retryable(scene = "localRetryWithBasicParams",localTimes = 4,localInterval = 10)
    public void localRetryWithBasicParams(){
        System.out.println("local retry 方法开始执行");
        double i = 1 / 0;
    }

    /**
     * 先抛出一个非指定的异常 不会进行重试
     */
    @Retryable(scene = "localRetryIncludeException",include = ParamException.class)
    public void localRetryExcludeException(){
        System.out.println("local retry include exception 方法开始执行");
        double i = 1 / 0;
    }

    /**
     * 抛出制定异常才会重试
     */
    @Retryable(scene = "localRetryIncludeException1",include = ParamException.class)
    public void localRetryIncludeException(){
        System.out.println("local retry include exception 方法开始执行");
        throw new ParamException("此处发生了指定异常Param Exception");
    }

}