package com.kenshine.service;

import com.kenshine.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 声明需要调用的微服务
 * @author Kenshine
 */
@FeignClient("service-provider")
public interface ProductService {

    /**
     * 查询商品列表
     * @return
     * 配置需要调用的服务地址及参数
     */
    @GetMapping("/product/list")
    List<Product> selectProductList();


    /**
     * 根据主键查询商品
     * @param id
     * @return
     */
    @GetMapping("/product/{id}")
    public Product selectProductById(@PathVariable("id") Integer id);



    /**
     * 根据主键查询商品
     * @RequestBody post接收参数
     * @param id
     * @return
     */
    @PostMapping("/product/single")
    public Product queryProductById(Integer id);

    /**
     * 新增商品
     * @param product
     * @return
     */
    @PostMapping("/product/save")
    public Map<Object, Object> createProduct(Product product);

    /**
     * get传递参数
     * @param product
     * @return
     */
    @GetMapping("/product/pojo")
    public Product selectProductByPojo(Product product);

}
