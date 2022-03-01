package com.kenshine.designpattern.gof18_Observer.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 19:22
 * @description：订阅
 * @modified By：
 * @version: $
 */
public class SubscriptionSubject implements Subject {
    //存储订阅的用户
    private List<Observer> weixinUserlist = new ArrayList<Observer>();

    @Override
    public void add(Observer observer) {
        weixinUserlist.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        weixinUserlist.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserlist) {
            observer.sendMessage(message);
        }
    }
}
