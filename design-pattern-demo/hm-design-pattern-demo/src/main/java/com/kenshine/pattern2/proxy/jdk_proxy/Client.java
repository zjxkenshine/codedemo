package com.kenshine.pattern2.proxy.jdk_proxy;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: jdk动态代理测试类
 * @Author: kenshine
 */
public class Client {
    public static void main(String[] args) {
        //获取代理对象
        //1,创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        //2,使用factory对象的方法获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        //3,调用卖调用的方法
        proxyObject.sell();

        System.out.println(proxyObject.getClass());
    }
}
