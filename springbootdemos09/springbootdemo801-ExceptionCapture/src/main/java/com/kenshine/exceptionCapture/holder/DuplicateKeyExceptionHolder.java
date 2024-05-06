package com.kenshine.exceptionCapture.holder;

import com.kenshine.exceptionCapture.exception.DuplicateKeyException;
import idea.verlif.spring.exception.ExceptionHolder;
import org.springframework.stereotype.Component;


/**
 * @author kenshine
 * 异常捕获处理类
 *
 * 需要实现ExceptionHolder接口并标记@Component注解。
 * 通过register()注册需要捕获的异常（此方法默认注册实现类注册的泛型，例如现在的DuplicateKeyException），
 * 通过handler(T e)方法来处理异常，并返回前端处理结果或异常意义
 */
@Component
public class DuplicateKeyExceptionHolder implements ExceptionHolder<DuplicateKeyException> {

    @Override
    public String handler(DuplicateKeyException e) {
        return "自定义异常处理："+e.getMessage();
    }
}