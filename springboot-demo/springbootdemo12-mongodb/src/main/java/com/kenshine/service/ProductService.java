package com.kenshine.service;

import com.kenshine.entity.Product;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 11:13
 * @description：产品业务接口
 * @modified By：
 * @version: $
 */
public interface ProductService {

    String saveProduct(Product product);

    /**
     * 查询所有
     */
    List<Product> findAll();


    /***
     * 根据id查询
     */
    Product getProductById(String id);

    /**
     * 根据名称查询
     */
    Product getProductByName(String name);

    /**
     * 更新对象
     */
    String updateProduct(Product product);

    /***
     * 删除对象
     */
    String deleteProduct(Product product);

    /**
     * 根据id删除
     */
    String deleteProductById(String id);

}
