package com.kenshine.designpattern.gof18_Observer.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 19:18
 * @description：观察者接口
 * @modified By：
 * @version: $
 */
public interface Observer {
    // 发送消息
    void sendMessage(String message);
}
