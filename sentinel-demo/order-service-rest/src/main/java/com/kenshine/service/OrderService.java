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
    Order searchOrderById(Integer id);


}
