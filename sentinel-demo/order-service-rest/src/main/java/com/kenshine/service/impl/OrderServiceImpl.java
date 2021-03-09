package com.kenshine.service.impl;

import com.kenshine.pojo.Order;
import com.kenshine.service.OrderService;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Kenshine
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;


    @Override
    public Order searchOrderById(Integer id) {
        return new Order(id,"order-001","中国",31994D, Arrays.asList(productService.selectProductById(5)));
    }

}
