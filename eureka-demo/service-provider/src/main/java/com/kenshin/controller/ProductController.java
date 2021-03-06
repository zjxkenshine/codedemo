package com.kenshin.controller;

import com.kenshin.pojo.Product;
import com.kenshin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kenshine
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询商品列表
     */
    @GetMapping("/list")
    public List<Product> selectProductList(){
        return productService.selectProductList();
    }


}
