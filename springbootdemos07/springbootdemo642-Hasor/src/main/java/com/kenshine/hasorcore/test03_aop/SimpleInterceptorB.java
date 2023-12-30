package com.kenshine.hasorcore.test03_aop;

import net.hasor.core.MethodInterceptor;
import net.hasor.core.MethodInvocation;

/**
 * @author by kenshine
 * @Classname SimpleInterceptorB
 * @Description 多拦截器B
 * @Date 2023-12-30 10:42
 * @modified By：
 * @version: 1.0$
 */
public class SimpleInterceptorB implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("类拦截器B before");
        Object returnData = methodInvocation.proceed();
        System.out.println("类拦截器B after");
        return returnData;
    }
}
