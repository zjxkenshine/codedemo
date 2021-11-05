package com.kenshine.pattern2.proxy.cglib_proxy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 7:52
 * @description：测试类
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        //创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        //获取代理对象
        TrainStation proxyObject = factory.getProxyObject();

        proxyObject.sell();
    }
}
