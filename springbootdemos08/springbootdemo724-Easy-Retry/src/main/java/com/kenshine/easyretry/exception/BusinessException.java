package com.kenshine.easyretry.exception;

/**
 * 定义一个统一的业务异常类
 * @author kenshine
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}