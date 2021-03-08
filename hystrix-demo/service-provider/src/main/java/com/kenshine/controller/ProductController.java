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
     * 查询商品列表
     * 模拟高并发，给服务中的该接口频繁发送请求
     */
    @GetMapping("/list")
    public List<Product> selectProductList() throws InterruptedException {
        Thread.sleep(2000);
        return productService.selectProductList();
    }

    /**
     * 根据主键查询商品
     */
    @GetMapping("/listByIds")
    public List<Product> selectProductByIds(@RequestParam("id") List<Integer> ids) {
        return productService.selectProductByIds(ids);
    }

    /**
     * 根据主键查询商品
     */
    @GetMapping("/{id}")
    public Product selectProductById(@PathVariable("id") Integer id){
        return productService.selectProductById(id);
    }









    /**
     * 根据主键查询商品
     * @RequestBody post接收参数
     */
    @PostMapping("/single")
    public Product queryProductById(@RequestBody Integer id){
        return productService.queryProductById(id);
    }

    /**
     * 新增商品
     * @param product
     * @return
     */
    @PostMapping("/save")
    public Map<Object, Object> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * 接收商品对象参数
     * @param product
     * @return
     */
    @GetMapping("/pojo")
    public Product selectProductByPojo(@RequestBody Product product) {
        return productService.selectProductByPojo(product);
    }



}
