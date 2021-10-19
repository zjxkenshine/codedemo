package com.kenshine.service;

import com.kenshine.fallback.ProductServiceFallbackFactory;
import com.kenshine.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 声明需要调用的微服务和服务熔断处理类
 * @author Kenshine
 */
@FeignClient(value = "product-service",fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {

    /**
     *  查询商品
     * @return
     */
    @GetMapping("/product/{id}")
    Product selectProductById(@PathVariable("id") Integer id);


}
