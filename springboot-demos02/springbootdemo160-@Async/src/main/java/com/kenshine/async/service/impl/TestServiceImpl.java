package com.kenshine.async.service.impl;

import com.kenshine.async.domain.User;
import com.kenshine.async.repository.UserRepository;
import com.kenshine.async.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 10:57
 * @description：业务接口实现
 * @modified By：
 * @version: $
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 无返回值任务
     */
    @Async
    @Override
    public void asyncTask() {
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：void asyncTask()，耗时：" + (endTime - startTime));
    }

    /**
     * 有返回值任务
     * @param s
     * @return
     */
    @Async("asyncTaskExecutor")
    @Override
    public Future<String> asyncTask(String s) {
        long startTime = System.currentTimeMillis();
        try {
            //模拟耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "：Future<String> asyncTask(String s)，耗时：" + (endTime - startTime));
        return AsyncResult.forValue(s);
    }


    /**
     * 事务
     * @param exFlag
     */
    @Async("asyncTaskExecutor")
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void asyncTaskForTransaction(Boolean exFlag) {
        //新增一个用户
        User user = new User();
        user.setUsername("kenshine");
        user.setPassword("123456");
        userRepository.save(user);

        if(exFlag){
            //模拟异常
            throw new RuntimeException("模拟异常");
        }
    }
}
