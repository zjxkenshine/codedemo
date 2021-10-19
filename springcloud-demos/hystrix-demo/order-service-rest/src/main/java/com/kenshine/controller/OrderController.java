package com.kenshine.controller;

import com.kenshine.pojo.Order;
import com.kenshine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kenshine
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}/product/list")
    public Order selectOrderById(@PathVariable("id") Integer id){
        return orderService.selectOrderById(id);
    }


    @GetMapping("/{id}/product/listByIds")
    public Order queryOrderById(@PathVariable("id") Integer id){
        return orderService.queryOrderById(id);
    }


    @GetMapping("/{id}/product")
    public Order searchOrderById(@PathVariable("id") Integer id){
        return orderService.searchOrderById(id);
    }

    @GetMapping("/{id}/product2")
    public Order searchOrderById2(@PathVariable("id") Integer id){
        return orderService.searchOrderById2(id);
    }

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @GetMapping("/{id}/product3")
    public Order searchOrderById3(@PathVariable("id") Integer id){
        return orderService.searchOrderById3(id);
    }




}
