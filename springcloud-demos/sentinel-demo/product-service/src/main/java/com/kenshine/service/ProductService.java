package com.kenshine.service;

import com.kenshine.pojo.Product;

import java.util.List;
import java.util.Map;

/**
 * 商品服务
 * @author Kenshine
 */
public interface ProductService {

    /**
     * 根据主键查询商品
     * @param id
     * @return
     */
    Product selectProductById(Integer id);



}
