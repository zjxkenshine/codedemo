package com.kenshine.metadata.demo03;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 11:10
 * @description：策略上下文 缓存策略
 * @modified By：
 * @version: $
 */
public class HandlerContext {
    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public HandlerContext() {
    }

    public AbstractRiskHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        return (AbstractRiskHandler) SpringContextUtil.getBean(clazz);
    }
}
