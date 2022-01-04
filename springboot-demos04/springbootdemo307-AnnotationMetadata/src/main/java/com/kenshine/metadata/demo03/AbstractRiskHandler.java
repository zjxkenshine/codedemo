package com.kenshine.metadata.demo03;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 11:11
 * @description：抽象策略类
 * @modified By：
 * @version: $
 */
public abstract class AbstractRiskHandler {
    public String handle(String req) {
        buildSceneData(req);

        return null;
    }

    protected abstract void buildSceneData(String req);
}
