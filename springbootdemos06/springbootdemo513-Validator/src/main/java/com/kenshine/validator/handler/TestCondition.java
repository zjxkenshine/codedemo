package com.kenshine.validator.handler;

import com.github.houbb.validator.api.api.condition.ICondition;
import com.github.houbb.validator.core.api.condition.Conditions;
import com.github.houbb.validator.core.api.condition.annotation.AbstractAnnotationCondition;
import com.kenshine.validator.annotation.AlwaysTrueCondition;

/**
 * @author by kenshine
 * @Classname TestCondition
 * @Description 自定义条件注解处理
 * @Date 2023-11-29 8:42
 * @modified By：
 * @version: 1.0$
 */
public class TestCondition extends AbstractAnnotationCondition<AlwaysTrueCondition> {

    @Override
    protected ICondition buildCondition(AlwaysTrueCondition alwaysTrueCondition) {
        System.out.println("自定义条件注解执行");
        return Conditions.alwaysTrue();
    }
}
