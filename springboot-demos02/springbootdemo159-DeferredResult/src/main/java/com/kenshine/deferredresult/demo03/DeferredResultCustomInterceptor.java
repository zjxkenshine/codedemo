package com.kenshine.deferredresult.demo03;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 9:52
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class DeferredResultCustomInterceptor implements DeferredResultProcessingInterceptor {

    @Override
    public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult){
        System.out.println("并发请求开始处理之前调用："+Thread.currentThread().getName());
    }

    @Override
    public <T> void preProcess(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
        System.out.println("并发请求处理之前调用："+Thread.currentThread().getName());
    }

    @Override
    public <T> void postProcess(NativeWebRequest request, DeferredResult<T> deferredResult, Object concurrentResult) throws Exception {
        System.out.println("setResult或setErrorResult后调用："+Thread.currentThread().getName());
    }

    /**
     * 其他接口
     * handlerTimeout
     * handlerError
     * afterCompletion
     */

}
