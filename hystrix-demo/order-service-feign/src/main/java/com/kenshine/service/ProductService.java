package com.kenshine.service;

import com.kenshine.fallback.ProductServiceFallback;
import com.kenshine.fallback.ProductServiceFallbackFactory;
import com.kenshine.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 声明需要调用的微服务和服务熔断处理类
 * @author Kenshine
 */
//@FeignClient(value = "service-provider",fallback = ProductServiceFallback.class)
@FeignClient(value = "service-provider",fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {
    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/product/list")
    List<Product> selectProductList();

    /**
     * 根据id列表查询商品列表
     */
    @GetMapping("/product/listByIds")
    List<Product> selectProductByIds(@RequestParam("id") List<Integer> ids);

    /**
     *  查询商品
     * @return
     */
    @GetMapping("/product/{id}")
    Product selectProductById(@PathVariable("id") Integer id);


}
