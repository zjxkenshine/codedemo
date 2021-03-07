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
     * 查询商品列表
     * @return List<Product>
     */
      List<Product> selectProductList();

    /**
     * 根据主键查询商品
     * @param id
     * @return
     */
    Product selectProductById(Integer id);

    /**
     *  --------POST-----------
     *  根据主键查询商品
     *  @param id
     *  @return
     */
    Product queryProductById(Integer id);

    /**
     * 新增商品
     * @param product
     * @return
     */
    Map<Object,Object> createProduct(Product product);





    /**
     * 接收商品对象传递参数 Get传递对象(httpclient配置)
     * @param product
     * @return
     */
    Product selectProductByPojo(Product product);

}
