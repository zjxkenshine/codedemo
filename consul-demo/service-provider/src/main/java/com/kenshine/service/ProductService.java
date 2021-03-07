package com.kenshine.service;

import com.kenshine.pojo.Product;

import java.util.List;

/**
 * 商品服务
 */
public interface ProductService {
    /**
     * 查询商品列表
     * @return List<Product>
     */
      List<Product> selectProductList();


}
