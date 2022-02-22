package com.kenshine.designpattern.gof17_Strategy.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 20:47
 * @description：正常收费策略
 * @modified By：
 * @version: $
 */
public class CashNormal implements CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
