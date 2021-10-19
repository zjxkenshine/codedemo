package com.kenshin.service.impl;

import com.kenshin.pojo.Order;
import com.kenshin.pojo.Product;
import com.kenshin.service.OrderService;
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

    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     *  负载均衡器
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Order selectOrderById(Integer id) {
       // return new Order(id,"order-001","中国",31994D,selectProductListByDiscoveryClient());
       // return new Order(id,"order-001","中国",31994D,selectProductListByLoadBalancerClient());
       // return new Order(id,"order-001","中国",31994D,selectProductListByLoadBalancerAnnotation());
        return new Order(id,"order-001","中国",31994D,selectProductListByLoadBalancerClient01());
    }

    /**
     * 远程调用方式一：元数据，RestTemplate
     * @return
     */
    private List<Product> selectProductListByDiscoveryClient() {
        StringBuffer sb=null;

        //获取服务列表
        List<String> serviceIds=discoveryClient.getServices();
        if(CollectionUtils.isEmpty(serviceIds)){
            return null;
        }

        //根据服务名称获取服务
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("SERVICE-PROVIDER");
        if(CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }

        ServiceInstance si=serviceInstances.get(0);
        sb=new StringBuffer();
        sb.append("http://"+si.getHost()+":"+si.getPort()+"/product/list");

        //ResponseEntity：封装了返回数据
        ResponseEntity<List<Product>> response=restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return response.getBody();

    }


    /**
     * 远程调用方式二：loadBalancerClient负载均衡器
     * @return
     */
    private List<Product> selectProductListByLoadBalancerClient(){
        StringBuffer sb=null;
        //根据服务名称获取服务
        ServiceInstance si=loadBalancerClient.choose("SERVICE-PROVIDER");
        if(si==null){
            return null;
        }
        sb=new StringBuffer();
        sb.append("http://"+si.getHost()+":"+si.getPort()+"/product/list");
        //ResponseEntity：封装了返回数据
        ResponseEntity<List<Product>> response=restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return response.getBody();
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


    /**
     * loadBalancerClient负载均衡器
     * Ribbon负载均衡方式：轮询策略
     * @return
     */
    private List<Product> selectProductListByLoadBalancerClient01(){
        StringBuffer sb=null;
        //根据服务名称获取服务
        ServiceInstance si=loadBalancerClient.choose("SERVICE-PROVIDER");
        if(si==null){
            return null;
        }
        sb=new StringBuffer();
        sb.append("http://"+si.getHost()+":"+si.getPort()+"/product/list");
        System.out.println(sb.toString());

        //ResponseEntity：封装了返回数据
        ResponseEntity<List<Product>> response=restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return response.getBody();
    }



}
