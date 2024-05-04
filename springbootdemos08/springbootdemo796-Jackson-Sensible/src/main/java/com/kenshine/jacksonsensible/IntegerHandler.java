package com.kenshine.jacksonsensible;

import idea.verlif.jackson.sensible.SerializeHandler;

/**
 * @author by kenshine
 * @Classname IntegerHandler
 * @Description 自定义处理器
 * @Date 2024-05-04 14:38
 * @modified By：
 * @version: 1.0$
 */
public class IntegerHandler implements SerializeHandler<Integer> {

    @Override
    public Class<?>[] match() {
        return new Class[]{Integer.class};
    }

    @Override
    public Object handle(Integer integer) {
        return 666;
    }
}
