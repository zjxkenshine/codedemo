package com.kenshine.flowable.exception;

import com.kenshine.flowable.entity.ErrorMsg;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常拦截器
 * @author: kenshine
 * @create: 2019-05-08 11:16
 **/
@ControllerAdvice
@ResponseBody
@Configuration
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ErrorMsg exceptionHandler(Exception e){
        e.printStackTrace();
        ErrorMsg errorMsg = ErrorMsg.UNKOWN_ERROR;
        errorMsg.setErrorDetail(e.toString());
        return errorMsg;
    }
}