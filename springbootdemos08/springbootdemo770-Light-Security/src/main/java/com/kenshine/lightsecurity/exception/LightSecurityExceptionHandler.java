package com.kenshine.lightsecurity.exception;

import com.itmuch.lightsecurity.exception.LightSecurityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kenshine
 * 异常处理
 */
@Slf4j
@ControllerAdvice
public class LightSecurityExceptionHandler {
    /**
     * Light Security相关异常
     */
    @ExceptionHandler(value = {LightSecurityException.class})
    @ResponseBody
    public ResponseEntity<String> error(LightSecurityException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}