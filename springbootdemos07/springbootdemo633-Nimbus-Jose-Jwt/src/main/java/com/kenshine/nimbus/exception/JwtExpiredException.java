package com.kenshine.nimbus.exception;

/**
 * @author by kenshine
 * @Classname JwtExpiredException
 * @Description 过期
 * @Date 2023-12-25 13:34
 * @modified By：
 * @version: 1.0$
 */
public class JwtExpiredException extends Exception{
    public JwtExpiredException(String message) {
        super(message);
    }
}
