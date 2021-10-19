package com.kenshine.service;

import com.kenshine.pojo.Product;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 声明需要调用的微服务
 * @author Kenshine
 */
public interface ProductService {
    /**
     * 查询商品列表
     * 请求缓存，线程隔离，信号量隔离示例
     * @return
     */
    List<Product> selectProductList();

    /**
     * 根据id列表查询商品列表
     * @param
     * @return
     */
    List<Product> selectProductByIds(List<Integer> ids);

    /**
     *  查询商品
     * @return
     */
    Product selectProductById(Integer id);

    /**
     * 异步请求，Hystrix请求合并示例
     * @param id
     * @return
     */
    Future<Product> selectProductById2(Integer id);

    /**
     * Hystrix服务熔断示例
     * @param id
     * @return
     */
    Product selectProductById3(Integer id);

}
