package com.kenshine.service.impl;

import com.kenshine.pojo.Order;
import com.kenshine.pojo.Product;
import com.kenshine.service.OrderService;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Kenshine
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Override
    public Order selectOrderById(Integer id) {
        return new Order(id,"order-001","中国",31994D, productService.selectProductList());
    }

    @Override
    public Order queryOrderById(Integer id) {
        return new Order(id,"order-001","中国",31994D, productService.selectProductByIds(Arrays.asList(1,2)));
    }

    @Override
    public Order searchOrderById(Integer id) {
        return new Order(id,"order-001","中国",31994D, Arrays.asList(productService.selectProductById(5)));
    }

}
