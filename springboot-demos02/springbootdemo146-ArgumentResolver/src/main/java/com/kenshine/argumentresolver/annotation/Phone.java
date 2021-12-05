package com.kenshine.argumentresolver.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 13:39
 * @description：自定义参数注解
 * @modified By：
 * @version: $
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
}
