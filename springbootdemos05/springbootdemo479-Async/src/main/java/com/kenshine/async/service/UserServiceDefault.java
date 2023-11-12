package com.kenshine.async.service;

import com.github.houbb.async.api.annotation.Async;
import com.github.houbb.async.core.model.async.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 测试service
 */
@Service
public class UserServiceDefault implements UserService{

    @Async
    @Override
    public AsyncResult<String> queryUser(String id) {
        System.out.println("开始根据用户id 查询用户信息 " + id);
        try {
            // 沉睡模拟处理耗时
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final String result = id + "-result";
        System.out.println("结束根据用户id 查询用户信息 " + result);

        AsyncResult<String> asyncResult = new AsyncResult<>();
        asyncResult.setValue(result);
        return asyncResult;
    }

}