package com.kenshine.annotation;

import com.github.houbb.sensitive.annotation.metadata.SensitiveCondition;
import com.kenshine.condition.ConditionFooPassword;

import java.lang.annotation.*;

/**
 * 自定义脱敏条件注解
 * @author kenshine
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveCondition(ConditionFooPassword.class)
public @interface SensitiveCustomPasswordCondition{
}