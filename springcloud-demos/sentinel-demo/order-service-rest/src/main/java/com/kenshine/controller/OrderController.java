package com.kenshine.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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

    @GetMapping("/{id}/product")
    public Order searchOrderById(@PathVariable("id") Integer id){
        return orderService.searchOrderById(id);
    }


}
