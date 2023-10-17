package com.kenshine.aspectj.aop;

import com.kenshine.aspectj.model.Account;

/**
 * @Classname AccountAspec
 * @Description .aj文件，用 AspectJ 的语法来写，对交易进行拦截，如此次交易超过余额，直接拒绝
 * @Date 2023-10-17 8:21
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */
public aspect AccountAspec {
    pointcut callPay(int amount, Account account):
            call(boolean com.kenshine.aspectj.model.Account.pay(int)) && args(amount) && target(account);

    before(int amount, Account account): callPay(amount, account) {
        // 不能用 lombok 会失效
        System.out.println("[AccountAspect]付款前总金额: " + account.balance);
        System.out.println("[AccountAspect]需要付款: " + amount);
    }

    boolean around(int amount, Account account): callPay(amount, account) {
        if (account.balance < amount) {
            System.out.println("[AccountAspect]拒绝付款!");
            return false;
        }
        return proceed(amount, account);
    }

    after(int amount, Account balance): callPay(amount, balance) {
        System.out.println("[AccountAspect]付款后，剩余：" + balance.balance);
    }
}
