package com.kenshine.pattern3.observer;

/**
 * @version v1.0
 * @ClassName: WeiXinUser
 * @Description: 具体的观察者角色类
 * @Author: kenshine
 */
public class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
