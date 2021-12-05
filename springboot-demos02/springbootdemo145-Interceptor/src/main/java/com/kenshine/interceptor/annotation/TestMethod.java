package com.kenshine.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 11:47
 * @description：测试注解，方法级别
 * @modified By：
 * @version: $
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestMethod {
}
