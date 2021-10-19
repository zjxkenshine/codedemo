package com.kenshine.service.impl;

import com.kenshine.pojo.Order;
import com.kenshine.pojo.Product;
import com.kenshine.service.OrderService;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kenshine
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Override
    public Order selectOrderById(Integer id) {
       // return new Order(id,"order-001","中国",31994D,productService.selectProductList());
        return new Order(id,"order-001","中国",31994D, Arrays.asList(productService.selectProductById(5)));
    }

}
