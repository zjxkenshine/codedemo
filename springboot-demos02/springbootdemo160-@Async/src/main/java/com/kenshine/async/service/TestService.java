package com.kenshine.async.service;

import java.util.concurrent.Future;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 10:56
 * @description：业务接口
 * @modified By：
 * @version: $
 */
public interface TestService {
    /**
     * 异步调用，无返回值
     */
    void asyncTask();

    /**
     * 异步调用，有返回值
     */
    Future<String> asyncTask(String s);

    /**
     * 异步调用，无返回值，事务测试
     */
    void asyncTaskForTransaction(Boolean exFlag);

}
