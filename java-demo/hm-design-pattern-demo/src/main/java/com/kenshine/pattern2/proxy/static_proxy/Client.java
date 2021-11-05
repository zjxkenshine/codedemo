package com.kenshine.pattern2.proxy.static_proxy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 7:35
 * @description：静态代理测试类
 * @modified By：
 * @version: $
 *
 * 静态代理代理类在编译期就生成，
 * 动态代理代理类则是在Java运行时动态生成。动态代理又有JDK代理和CGLib代理两种
 */
public class Client {

    public static void main(String[] args) {
        //通过代理访问
        ProxyPoint pp = new ProxyPoint();
        pp.sell();
    }
}
