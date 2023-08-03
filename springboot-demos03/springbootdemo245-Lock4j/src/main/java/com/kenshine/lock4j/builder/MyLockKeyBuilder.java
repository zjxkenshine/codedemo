package com.kenshine.lock4j.builder;

import com.baomidou.lock.DefaultLockKeyBuilder;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author by kenshine
 * @Classname MyLockKeyBuilder
 * @Description 自定义key生成器
 * @Date 2023-08-03 19:19
 * @modified By：
 * @version: 1.0$
 */
@Component
public class MyLockKeyBuilder extends DefaultLockKeyBuilder {
    public MyLockKeyBuilder(BeanFactory beanFactory) {
        super(beanFactory);
    }


    @Override
    public String buildKey(MethodInvocation invocation, String[] definitionKeys) {
        String key = super.buildKey(invocation, definitionKeys);
        System.out.println("重写了key生成器！");
        return key;
    }
}
