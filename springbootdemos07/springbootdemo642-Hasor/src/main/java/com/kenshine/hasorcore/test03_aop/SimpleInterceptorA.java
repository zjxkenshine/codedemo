package com.kenshine.hasorcore.test03_aop;

import net.hasor.core.MethodInterceptor;
import net.hasor.core.MethodInvocation;

/**
 * @author by kenshine
 * @Classname SimpleInterceptorA
 * @Description 多拦截器A
 * @Date 2023-12-30 10:41
 * @modified By：
 * @version: 1.0$
 */
public class SimpleInterceptorA implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("类拦截器A before");
        Object returnData = methodInvocation.proceed();
        System.out.println("类拦截器A after");
        return returnData;
    }
}
