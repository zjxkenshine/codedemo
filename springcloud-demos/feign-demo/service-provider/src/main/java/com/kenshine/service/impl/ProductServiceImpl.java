package com.kenshine.service.impl;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kenshine
 */
@Service
public class ProductServiceImpl implements ProductService{


    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1,"华为手机-7070",2,5888D),
                new Product(2,"联想笔记本电脑",1,6888D)
        );
    }


    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @Override
    public Product selectProductById(Integer id) {
        try {
            Thread.sleep(2000L);
        }catch (Exception e){
        }
        return new Product(id,"冰箱",1,6666D);
    }

    @Override
    public Product queryProductById(Integer id) {
        return new Product(id,"冰箱",1,6666D);
    }

    @Override
    public Map<Object, Object> createProduct(Product product) {
        System.out.println(product);
        return new HashMap<Object, Object>(16){{
            put("code",20);
            put("message","新增成功");
        }};
    }

    @Override
    public Product selectProductByPojo(Product product) {
        System.out.println(product);
        return product;
    }

}
