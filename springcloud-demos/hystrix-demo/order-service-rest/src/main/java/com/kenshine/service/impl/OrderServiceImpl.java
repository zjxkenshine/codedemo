package com.kenshine.service.impl;

import com.kenshine.pojo.Order;
import com.kenshine.pojo.Product;
import com.kenshine.service.OrderService;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Order searchOrderById2(Integer id) {
        //模拟同一时间用户多次发送请求
        Future<Product> p1=productService.selectProductById2(1);
        Future<Product> p2=productService.selectProductById2(2);
        Future<Product> p3=productService.selectProductById2(3);
        Future<Product> p4=productService.selectProductById2(4);
        Future<Product> p5=productService.selectProductById2(5);
        try{
            System.out.println(p1.get());
            System.out.println(p2.get());
            System.out.println(p3.get());
            System.out.println(p4.get());
            System.out.println(p5.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return new Order(id,"order-003","中国",29000D,null);
    }

    @Override
    public Order searchOrderById3(Integer id) {
        return new Order(id,"order-001","中国",31994D, Arrays.asList(productService.selectProductById3(5)));
    }

}
