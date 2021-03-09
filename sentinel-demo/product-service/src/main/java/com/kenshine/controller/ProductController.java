package com.kenshine.controller;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kenshine
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * 根据主键查询商品
     */
    @GetMapping("/{id}")
    public Product selectProductById(@PathVariable("id") Integer id){
        return productService.selectProductById(id);
    }



}
