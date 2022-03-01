package com.kenshine.designpattern.gof18_Observer.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 19:21
 * @description：主体接口
 * @modified By：
 * @version: $
 */
public interface Subject {
    /**
     * 增加订阅者
     * @param observer
     */
    public void add(Observer observer);
    /**
     * 删除订阅者
     * @param observer
     */
    public void remove(Observer observer);
    /**
     * 通知订阅者更新消息
     */
    public void notify(String message);
}
