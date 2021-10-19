package com.kenshine.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * productService 实现类
 * 使用Ribbon需要写
 * @author Kenshine
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @param id
     * @return
     * 基于restTemplate的控制则可以不写这个
     */
//    @SentinelResource(
//            value = "selectProductById",        //名称
//            blockHandler = "selectProductByIdBlockHandler",      //流量控制处理方法   不能为private
//            fallback = "selectProductByIdFallback"          //服务熔断降级处理方法   不能为private
//    )
    @Override
    public Product selectProductById(Integer id) {
        System.out.println("-----------orderService------------selectProductById---------------");
        //模拟查询主键为1的商品出现异常
        if(id==1){
            throw new RuntimeException("查询主键为1的商品信息导致异常");
        }
        return restTemplate.getForObject("http://product-service/product/"+id,Product.class);
    }


    /**
     * 流量控制方法，参数最后多了一个BlockException,其余与原函数一样
     * @return
     */
    public Product selectProductByIdBlockHandler(Integer id,BlockException ex){
        ex.printStackTrace();
        return new Product(1,"流量控制处理-托底数据-手机",1,5800D);
    }

    /**
     * 服务熔断降级方法，与原函数一致或加一个 throwable 类型的参数
     * @return
     */
    public Product selectProductByIdFallback(Integer id,Throwable throwable){
        System.out.println("出错："+throwable);
        return new Product(id,"熔断降级处理-托底数据-电视",1,2666D);
    }

}
