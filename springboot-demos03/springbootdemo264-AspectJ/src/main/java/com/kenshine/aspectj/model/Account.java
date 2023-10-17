package com.kenshine.aspectj.model;

/**
 * @author by kenshine
 * @Classname Account
 * @Description 金额
 * @Date 2023-10-17 8:22
 * @modified By：
 * @version: 1.0$
 */
public class Account {
    public int balance = 20;

    public boolean pay(int amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
