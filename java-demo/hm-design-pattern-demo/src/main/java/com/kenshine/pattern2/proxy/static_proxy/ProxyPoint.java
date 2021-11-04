package com.kenshine.pattern2.proxy.static_proxy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 7:35
 * @description：代售点
 * @modified By：
 * @version: $
 */
public class ProxyPoint implements SellTickets{

    private TrainStation station = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理点收取一些服务费用");
        station.sell();
    }

}
