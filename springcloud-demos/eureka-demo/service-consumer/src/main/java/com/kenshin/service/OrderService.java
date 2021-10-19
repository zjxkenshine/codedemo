package com.kenshin.service;

import com.kenshin.pojo.Order;

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

}
