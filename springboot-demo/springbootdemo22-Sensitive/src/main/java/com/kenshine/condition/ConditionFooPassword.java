package com.kenshine.condition;

import com.github.houbb.sensitive.api.ICondition;
import com.github.houbb.sensitive.api.IContext;

import java.lang.reflect.Field;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 11:22
 * @description：自定义脱敏策略生效的场景
 * @modified By：
 * @version: $
 */
public class ConditionFooPassword implements ICondition {
    @Override
    public boolean valid(IContext context) {
        try {
            Field field = context.getCurrentField();
            final Object currentObj = context.getCurrentObject();
            final String password = (String) field.get(currentObj);
            return !password.equals("123456");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
