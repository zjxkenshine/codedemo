package com.kenshin.service;

import com.kenshin.pojo.Product;
import org.springframework.stereotype.Service;

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
