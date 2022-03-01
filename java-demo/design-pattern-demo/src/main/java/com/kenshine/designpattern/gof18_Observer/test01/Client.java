package com.kenshine.designpattern.gof18_Observer.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/1 19:23
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject=new SubscriptionSubject();
        //创建微信用户
        WeixinUser user1=new WeixinUser("qin");
        WeixinUser user2=new WeixinUser("666");
        WeixinUser user3=new WeixinUser("小王");
        //订阅公众号
        mSubscriptionSubject.add(user1);
        mSubscriptionSubject.add(user2);
        mSubscriptionSubject.add(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notify("Kenshine的专栏更新了");
    }
}
