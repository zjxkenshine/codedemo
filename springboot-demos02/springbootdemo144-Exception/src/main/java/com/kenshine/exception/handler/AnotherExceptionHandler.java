package com.kenshine.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 10:15
 * @description：另一个异常处理器(冲突的)
 * @modified By：
 * @version: $
 */
@RestControllerAdvice
public class AnotherExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object handleException(Exception e, HttpServletRequest request) {
        return null;
    }
}
