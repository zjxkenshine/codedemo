package com.kenshine.aspectj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author by kenshine
 * @Classname ProfilingAspect
 * @Description 用 Java 来写，用于记录方法的执行时间
 * @Date 2023-10-17 8:24
 * @modified By：
 * @version: 1.0$
 */
@Aspect
public class ProfilingAspect {
    // 扫描包
    @Pointcut("execution(* com.kenshine.aspectj.model.*.*(..))")
    public void modelLayer() {
    }

    @Around("modelLayer()")
    public Object logProfile(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.out.println("[ProfilingAspect]方法: 【" + joinPoint.getSignature() + "】结束，用时: " + (System.currentTimeMillis() - start));
        return result;
    }
}
