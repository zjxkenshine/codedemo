package com.kenshine.hasorcore.test03_aop;

import net.hasor.core.MethodInterceptor;
import net.hasor.core.MethodInvocation;

/**
 * @author by kenshine
 * @Classname SimpleInterceptor
 * @Description AOP拦截器
 * @Date 2023-12-30 10:29
 * @modified By：
 * @version: 1.0$
 */
public class SimpleInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            System.out.println("before... ");
            Object returnData = invocation.proceed();
            System.out.println("after...");
            return returnData;
        } catch (Exception e) {
            System.out.println("throw...");
            throw e;
        }
    }
}
