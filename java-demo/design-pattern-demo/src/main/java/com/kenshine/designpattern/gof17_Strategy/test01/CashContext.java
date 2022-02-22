package com.kenshine.designpattern.gof17_Strategy.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/22 20:46
 * @description：收费上下文
 * @modified By：
 * @version: $
 */
public class CashContext {
    // 收费策略
    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
