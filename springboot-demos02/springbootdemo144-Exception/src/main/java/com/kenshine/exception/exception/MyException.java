package com.kenshine.exception.exception;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 9:54
 * @description：自定义异常
 * @modified By：
 * @version: $
 */
public class MyException extends RuntimeException {
    protected final String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
