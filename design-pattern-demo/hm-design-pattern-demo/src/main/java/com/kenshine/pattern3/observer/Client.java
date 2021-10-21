package com.kenshine.pattern3.observer;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 观察者模式测试类
 * @Author: kenshine
 *
 *  **1，优点：**
 *
 * * 降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。
 * * 被观察者发送通知，所有注册的观察者都会收到信息【可以实现广播机制】
 *
 *  **2，缺点：**
 *
 * * 如果观察者非常多的话，那么所有的观察者收到被观察者发送的通知会耗时
 * * 如果被观察者有循环依赖的话，那么被观察者发送通知会使观察者循环调用，会导致系统崩溃
 *
 * 使用场景：
 *    对象间存在一对多关系，一个对象的状态发生改变会影响其他对象。（一个数据删除影响其他数据等）
 *    当一个抽象模型有两个方面，其中一个方面依赖于另一方面时
 */
public class Client {
    public static void main(String[] args) {
        //1,创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        //2,订阅公众号
        subject.attach(new WeiXinUser("孙悟空"));
        subject.attach(new WeiXinUser("猪悟能"));
        subject.attach(new WeiXinUser("沙悟净"));

        //3,公众号更新，发出消息给订阅者（观察者对象）
        subject.notify("公众号更新了！");
    }
}
