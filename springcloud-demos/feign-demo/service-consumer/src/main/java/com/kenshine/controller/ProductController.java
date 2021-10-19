package com.kenshine.controller;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Kenshine
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 根据主键查询商品
     */
    @PostMapping("/info")
    public Product queryProductById(Integer id){
        return productService.queryProductById(id);
    }

    @PostMapping("/save")
    public Map<Object,Object> createProduct(Product product){
        return productService.createProduct(product);
    }

    /**
     * 接收商品对象参数(配置了httpclient)
     * 注意这里没有@RequestBody
     * @param product
     * @return
     */
    @GetMapping("/pojo")
    public Product selectProductByPojo(Product product) {
        return productService.selectProductByPojo(product);
    }

}
