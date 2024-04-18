package com.kenshine.xss.exception;

/**
 * @author by kenshine
 * @Classname CustomerException
 * @Description 自定义异常
 * @Date 2024-04-18 8:22
 * @modified By：
 * @version: 1.0$
 */
public class CustomerException extends RuntimeException{

    public CustomerException(String message) {
        super(message);
    }
}
