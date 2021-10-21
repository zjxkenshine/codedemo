package com.kenshine.pattern3.strategy;

/**
 * @version v1.0
 * @ClassName: SalesMan
 * @Description: 促销员(环境类)
 * @Author: kenshine
 */
public class SalesMan {

    //聚合策略类对象
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    //由促销员展示促销活动给用户
    public void salesManShow() {
        strategy.show();
    }
}
