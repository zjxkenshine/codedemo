package com.kenshine.handler;

import com.kenshine.domain.CommonResult;
import com.kenshine.exception.InvalidParameterException;
import com.kenshine.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:38
 * @description：全局异常处理
 * @modified By：
 * @version: $
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public CommonResult<Object> invalidParameterException(InvalidParameterException e) {
        String message = e.getMessage();
        LOGGER.error("异常信息：" + message, e);
        return CommonResult.invalidParameter(message);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public CommonResult<Object> notFoundException(NotFoundException e) {
        String message = e.getMessage();
        LOGGER.error("异常信息：" + message, e);
        return CommonResult.notFound(message);
    }

}
