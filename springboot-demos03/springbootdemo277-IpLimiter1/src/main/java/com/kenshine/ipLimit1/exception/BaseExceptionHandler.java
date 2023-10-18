package com.kenshine.ipLimit1.exception;

import com.van.limiter.core.exception.IpLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常
 */
@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

  @ExceptionHandler(IpLimitException.class)
  @ResponseBody
  public String resolveCommonException(IpLimitException e) {
    log.error("IpLimitException Intercept. Please try again later.. " + e.getMessage());
    return "IpLimitException Intercept. Please try again later.. ";
  }
  
}