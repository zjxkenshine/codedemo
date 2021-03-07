package com.kenshine.service.impl;

import com.kenshine.pojo.Order;
import com.kenshine.pojo.Product;
import com.kenshine.service.OrderService;
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

import java.util.List;

/**
 * @author Kenshine
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order selectOrderById(Integer id) {
       return new Order(id,"order-001","中国",31994D,selectProductListByLoadBalancerAnnotation());
    }


    /**
     * 远程调用方式三：启动类注册restTemplate时添加@LoadBalanced注解，自动负载均衡
     * @return
     */
    private List<Product> selectProductListByLoadBalancerAnnotation(){
        //ResponseEntity：封装了返回数据
        ResponseEntity<List<Product>> response=restTemplate.exchange(
                "http://service-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return response.getBody();
    }



}
