package com.kenshine.jacksonsensible;

import idea.verlif.jackson.sensible.SerializeHandler;

/**
 * @author kenshine
 * 自定义脱敏处理
 */
public class StringHandler implements SerializeHandler<String> {

    /**
     * 处理器匹配的类。
     */
    @Override
    public Class<?>[] match() {
        return new Class[]{String.class};
    }

    @Override
    public Object handle(String val) {
        return "*****";
    }
}