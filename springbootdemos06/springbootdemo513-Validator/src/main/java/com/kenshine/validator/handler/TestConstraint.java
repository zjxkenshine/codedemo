package com.kenshine.validator.handler;

import com.github.houbb.validator.api.api.constraint.IConstraint;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.api.constraint.annotation.AbstractAnnotationConstraint;
import com.kenshine.validator.annotation.AllEquals;

/**
 * @author by kenshine
 * @Classname TestConstraint
 * @Description 自定义约束注解处理
 * @Date 2023-11-29 8:39
 * @modified By：
 * @version: 1.0$
 */
public class TestConstraint extends AbstractAnnotationConstraint<AllEquals> {

    @Override
    protected IConstraint buildConstraint(AllEquals allEquals) {
        System.out.println("自定义约束注解执行");
        return Constraints.allEquals(allEquals.value());
    }
}
