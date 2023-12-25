package com.kenshine.nimbus.exception;

/**
 * @author by kenshine
 * @Classname JwtInvalidException
 * @Description 不合法
 * @Date 2023-12-25 13:34
 * @modified By：
 * @version: 1.0$
 */
public class JwtInvalidException extends Exception{
    public JwtInvalidException(String message) {
        super(message);
    }
}
