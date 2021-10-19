package com.kenshine.fallback;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;

import java.util.Arrays;
import java.util.List;

/**
 * 服务熔断降级处理
 */
//@Component
public class ProductServiceFallback implements ProductService {


    @Override
    public Product selectProductById(Integer id) {
        return new Product(1,"托底数据-电视机",1,7000D);
    }
}
