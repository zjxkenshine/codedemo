package com.kenshine.service;

import com.kenshine.pojo.Order;

/**
 * @author Kenshine
 */
public interface OrderService {
    /**
     * 根据主键查询订单
     * @param id
     * @return
     */
    Order selectOrderById(Integer id);

    /**
     * 根据主键查询订单
     * @param id
     * @return
     */
    Order queryOrderById(Integer id);


    /**
     * 根据主键查询订单
     * @param id
     * @return
     */
    Order searchOrderById(Integer id);


    /**
     * 根据主键查询订单
     * 请求合并方式
     * @param id
     * @return
     */
    Order searchOrderById2(Integer id);


    /**
     * 根据主键查询订单
     * 服务熔断示例
     * @param id
     * @return
     */
    Order searchOrderById3(Integer id);

}
