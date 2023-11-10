package com.kenshine.strategy;

import com.github.houbb.sensitive.api.IContext;
import com.github.houbb.sensitive.api.IStrategy;

/**
 * 自定义脱敏策略
 */
public class CustomPasswordStrategy implements IStrategy {

    @Override
    public Object des(Object original, IContext context) {
        return "**********************";
    }

}