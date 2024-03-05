package com.kenshine.easyretry.exception;

import com.kenshine.easyretry.exception.BusinessException;

/**
 * 定义一个参数异常处理类,是业务异常类的子类
 * @author kenshine
 */
public class ParamException extends BusinessException {
    public ParamException(String message) {
        super(message);
    }
}