package com.kenshine.validator.annotation;

import com.github.houbb.validator.api.annotation.condition.Condition;
import com.kenshine.validator.handler.TestCondition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by kenshine
 * @Classname AlwaysTrueCondition
 * @Description 自定义条件注解
 * @Date 2023-11-29 8:41
 * @modified By：
 * @version: 1.0$
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Condition(TestCondition.class)
public @interface AlwaysTrueCondition {
}
