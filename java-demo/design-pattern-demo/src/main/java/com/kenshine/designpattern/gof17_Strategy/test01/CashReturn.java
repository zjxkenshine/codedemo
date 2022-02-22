package com.kenshine.designpattern.gof17_Strategy.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 20:48
 * @description：收费返利
 * @modified By：
 * @version: $
 */
public class CashReturn implements CashSuper{
    private double moneyConditation = 0.0;    //返利条件
    private double moneyReturn = 0.0d;    //返利值

    public CashReturn(double moneyConditation, double moneyReturn) {
        this.moneyConditation = moneyConditation;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;

        if (money >= moneyConditation) {
            result = money - Math.floor(money / moneyConditation) * moneyReturn;
        }

        return result;
    }
}
