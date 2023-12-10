package com.kenshine.functional.exception;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/10 20:21
 * @description：测试异常
 * @modified By：
 * @version: $
 */
public class TestException extends Exception{
    @Override
    public String getMessage() {
        return "test exception";
    }
}
