package com.kenshine.exceptionCapture.holder;

import idea.verlif.spring.exception.BaseExceptionHolder;
import org.springframework.stereotype.Component;

/**
 * @author kenshine
 * 默认异常处理
 * 处理未捕获的类
 */
@Component
public class BaseExceptionHolderImpl implements BaseExceptionHolder {

    @Override
    public String handler(Throwable throwable) {
        return "未捕获异常处理："+throwable.getMessage();
    }
}