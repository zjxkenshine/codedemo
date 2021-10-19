package com.kenshine.pattern2.proxy.static_proxy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 7:35
 * @description：火车站
 * @modified By：
 * @version: $
 */
public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
