package com.kenshine.service;

import com.kenshine.pojo.Product;

/**
 * 声明需要调用的微服务
 * @author Kenshine
 */
public interface ProductService {

    /**
     *  查询商品
     * @return
     */
    Product selectProductById(Integer id);


}
