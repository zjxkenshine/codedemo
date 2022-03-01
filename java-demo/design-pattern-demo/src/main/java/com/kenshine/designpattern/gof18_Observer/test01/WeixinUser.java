package com.kenshine.designpattern.gof18_Observer.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 19:20
 * @description： 微信观察者
 * @modified By：
 * @version: $
 */
public class WeixinUser implements Observer {
    // 微信用户名
    private String name;
    public WeixinUser(String name) {
        this.name = name;
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(name + "-" + message);
    }
}
