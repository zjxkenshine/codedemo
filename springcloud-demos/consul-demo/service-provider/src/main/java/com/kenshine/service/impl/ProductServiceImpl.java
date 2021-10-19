package com.kenshine.service.impl;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author kenshine
 */
@Service
public class ProductServiceImpl implements ProductService{


    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1,"华为手机",2,5888D),
                new Product(2,"联想笔记本电脑",1,6888D)
        );
    }
}
