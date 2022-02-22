package com.kenshine.designpattern.gof17_Strategy.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 20:47
 * @description：打折收费
 * @modified By：
 * @version: $
 */
public class CashRebate implements CashSuper{
    private double moneyRebate = 1;    //折扣

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
