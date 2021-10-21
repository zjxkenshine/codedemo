package com.kenshine.pattern3.strategy;

/**
 * @version v1.0
 * @ClassName: StrategyA
 * @Description: 具体策略类，封装算法
 * @Author: kenshine
 */
public class StrategyA implements Strategy {

    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
