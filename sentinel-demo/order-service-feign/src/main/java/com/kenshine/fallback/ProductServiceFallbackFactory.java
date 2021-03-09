package com.kenshine.fallback;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 服务熔断降级处理，可以捕获异常
 */
@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {

    /**
     * 获取日志，在需要捕获异常的方法中进行处理
     */
    Logger logger= LoggerFactory.getLogger(ProductServiceFallbackFactory.class);

    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {

            @Override
            public Product selectProductById(Integer id) {

                return new Product(1,"托底数据-电视机",1,7000D);
            }
        };
    }




}
