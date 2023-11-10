package com.kenshine.annotation;

import com.github.houbb.sensitive.annotation.metadata.SensitiveStrategy;
import com.kenshine.strategy.CustomPasswordStrategy;

import java.lang.annotation.*;

/**
 *  @author kenshine
 * @SensitiveStrategy 策略单独使用的时候，默认是生效的
 * 如果有 @SensitiveCondition 注解，则只有当条件满足时，才会执行脱敏策略
 * @SensitiveCondition 只会对系统内置注解和自定义注解生效，因为 @Sensitive 有属于自己的策略生效条件
 * @Sensitive 优先生效，然后是系统内置注解，最后是用户自定义注解
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveStrategy(CustomPasswordStrategy.class)
public @interface SensitiveCustomPasswordStrategy {
}