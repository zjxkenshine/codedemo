package com.kenshine.lock4j.service;

import com.baomidou.lock.LockInfo;
import com.baomidou.lock.LockTemplate;
import com.baomidou.lock.executor.RedissonLockExecutor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author by kenshine
 * @Classname ProgrammaticService
 * @Description 手动上锁解锁
 * @Date 2023-08-03 19:28
 * @modified By：
 * @version: 1.0$
 */
public class ProgrammaticService {

    @Autowired
    private LockTemplate lockTemplate;

    public void programmaticLock(String userId) {
        int counter=0;
        // 各种查询操作 不上锁
        // ...
        // 获取锁
        final LockInfo lockInfo = lockTemplate.lock(userId, 30000L, 5000L, RedissonLockExecutor.class);
        if (null == lockInfo) {
            throw new RuntimeException("业务处理中,请稍后再试");
        }
        // 获取锁成功，处理业务
        try {
            System.out.println("执行简单方法1 , 当前线程:" + Thread.currentThread().getName() + " , counter：" + (counter++));
        } finally {
            //释放锁
            lockTemplate.releaseLock(lockInfo);
        }
        //结束
    }

}
