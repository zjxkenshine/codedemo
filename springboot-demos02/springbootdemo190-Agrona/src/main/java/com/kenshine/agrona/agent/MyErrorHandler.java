package com.kenshine.agrona.agent;

import org.agrona.ErrorHandler;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 9:58
 * @description：自定义错误处理器
 * @modified By：
 * @version: $
 */
public class MyErrorHandler implements ErrorHandler {
    @Override
    public void onError(Throwable throwable) {
        System.err.println("出大问题了！！！");
    }
}
