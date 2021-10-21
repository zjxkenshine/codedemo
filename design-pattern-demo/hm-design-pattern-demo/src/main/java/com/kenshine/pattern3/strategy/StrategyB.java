package com.kenshine.pattern3.strategy;

/**
 * @version v1.0
 * @ClassName: StrategyB
 * @Description: 具体策略类，封装算法
 * @Author: kenshine
 */
public class StrategyB implements Strategy {

    @Override
    public void show() {
        System.out.println("满200元减50元");
    }
}
