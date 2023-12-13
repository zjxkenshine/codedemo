package com.kenshine.djcproxy.interceptor;

import com.javax0.djcproxy.MethodInterceptor;
import com.javax0.djcproxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname UserInterceptor
 * @Description 用户拦截器
 * @Date 2023-12-13 8:52
 * @modified By：
 * @version: 1.0$
 */
public class UserInterceptor implements MethodInterceptor {
    /**
     * 代理拦截方法
     * @param o 原始对象，调用方法的对象
     * @param method 方法对象
     * @param objects 参数列表
     * @param methodProxy 方法代理
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 代理setName()方法
        if ("setName".equals(method.getName())) {
            System.out.println("调用了User代理对象的SetName方法");
            System.out.println("start="+System.currentTimeMillis());
            Object o1=methodProxy.invoke(o,new Object[]{"test_"+objects[0]});
            System.out.println("finish="+System.currentTimeMillis());
            return o1;
        }

        if ("getName".equals(method.getName())) {
            System.out.println("调用了User代理对象的getName方法");
            return methodProxy.invoke(o,new Object[]{});
        }
        return methodProxy.invoke(o,objects);
    }
}
