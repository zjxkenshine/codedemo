package com.kenshine.lock4j.failure;

import com.baomidou.lock.LockFailureStrategy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname MyLockFailureStrategy
 * @Description 自定义锁失败策略
 * @Date 2023-08-03 19:26
 * @modified By：
 * @version: 1.0$
 */
@Component
public class MyLockFailureStrategy implements LockFailureStrategy {
    @Override
    public void onLockFailure(String key, Method method, Object[] arguments) {
        System.out.println("自定义锁失败策略！");
    }
}
