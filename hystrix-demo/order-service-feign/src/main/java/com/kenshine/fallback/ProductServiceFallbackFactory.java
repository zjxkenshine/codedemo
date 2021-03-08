package com.kenshine.fallback;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import com.netflix.appinfo.RefreshableAmazonInfoProvider;

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
            public List<Product> selectProductList() {
                logger.error("product-service 服务的 selectProductList 方法出现异常，信息如下："+throwable);
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
        };
    }




}
