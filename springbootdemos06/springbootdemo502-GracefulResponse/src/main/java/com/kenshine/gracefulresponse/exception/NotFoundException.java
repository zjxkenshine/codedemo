package com.kenshine.gracefulresponse.exception;

import com.feiniaojin.gracefulresponse.api.ExceptionAliasFor;
import com.feiniaojin.gracefulresponse.api.ExceptionMapper;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author by kenshine
 * @Classname NotFoundException
 * @Description notfund
 * @Date 2023-11-25 8:31
 * @modified By：
 * @version: 1.0$
 * ExceptionAliasFor 异常别名
 */
@ExceptionMapper(code = "1404", msg = "找不到对象")
@ExceptionAliasFor(code = "1404", msg = "not found", aliasFor = NoHandlerFoundException.class)
public class NotFoundException extends RuntimeException{
}
