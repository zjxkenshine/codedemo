package com.kenshine.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author kenshine
 */
@Service
public class ProductServiceImpl implements ProductService{

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @Override
    public Product selectProductById(Integer id) {
        return new Product(id,"冰箱",1,6666D);
    }



}
