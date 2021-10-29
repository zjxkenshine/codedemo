package com.kenshine.service;

import com.kenshine.domain.CommonResult;
import com.kenshine.domain.Order;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:34
 * @description：订单业务接口
 * @modified By：
 * @version: $
 */
public interface OrderService {
    /**
     * 保存订单
     *
     * @param order 订单参数
     * @return CommonResult<Order>
     */
    CommonResult<Order> saveOrder(Order order);

    /**
     * 查询所有订单
     *
     * @return CommonResult<List<Order>>
     */
    CommonResult<List<Order>> findOrderAll();

    /**
     * 根据id更新订单
     *
     * @param order 订单参数
     * @return CommonResult<Order>
     */
    CommonResult<Order> updateOrderById(Order order);

    /**
     * 根据id删除订单
     *
     * @param id 订单id
     * @return CommonResult<Order>
     */
    CommonResult<Order> deleteOrderById(Long id);

}
