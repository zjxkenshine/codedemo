package com.kenshine.fallback;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 服务熔断降级处理
 */
//@Component
public class ProductServiceFallback implements ProductService {

    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1,"托底数据-手机",1,5800D),
                new Product(2,"托底数据-笔记本电脑",1,6666D),
                new Product(3,"托底数据-小米平板",5,2020D)
        );
    }

    @Override
    public List<Product> selectProductByIds(List<Integer> ids) {
        return Arrays.asList(
                new Product(1,"托底数据-手机",1,5800D),
                new Product(2,"托底数据-笔记本电脑",1,6666D),
                new Product(3,"托底数据-小米平板",5,2020D)
        );
    }

    @Override
    public Product selectProductById(Integer id) {
        return new Product(1,"托底数据-电视机",1,7000D);
    }
}
