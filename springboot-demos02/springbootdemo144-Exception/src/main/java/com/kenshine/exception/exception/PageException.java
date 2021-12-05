package com.kenshine.exception.exception;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 9:58
 * @description：自定义异常2
 * @modified By：
 * @version: $
 */
public class PageException extends RuntimeException {
    private static final long serialVersionUID = 564865168498L;

    private final String message;


    public PageException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
