package com.kenshine.guavaretrying.retry;

/**
 * @author kenshine
 * 自定义重试异常
 */
public class NeedRetryException extends Exception {
 
    public NeedRetryException(String message) {
        super("NeedRetryException can retry."+message);
    }
 
}
