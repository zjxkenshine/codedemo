package com.kenshine.pattern3.strategy;

/**
 * @version v1.0
 * @ClassName: StrategyC
 * @Description: 具体策略类，封装算法
 * @Author: kenshine
 */
public class StrategyC implements Strategy {

    @Override
    public void show() {
        System.out.println("满1000元加一元换购任意200元以下商品");
    }


}
