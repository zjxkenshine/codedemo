package com.kenshine.web;

import com.kenshine.entity.Product;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 11:15
 * @description：产品Controller
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public String saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/id/{id}")
    public Product findOne(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public Product findOneByName(@PathVariable("name") String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/update")
    public String update(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delOne")
    public String delOne(@RequestBody Product product) {
        return productService.deleteProduct(product);
    }

    @DeleteMapping("/{id}")
    public String delById(@PathVariable("id") String id) {
        return productService.deleteProductById(id);
    }

}
