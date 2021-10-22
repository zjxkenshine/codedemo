package com.kenshine.service.impl;

import com.kenshine.entity.Product;
import com.kenshine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 11:13
 * @description：产品业务impl
 * @modified By：
 * @version: $
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String saveProduct(Product product) {
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        mongoTemplate.save(product);
        return "添加成功";
    }

    @Override
    public List<Product> findAll() {
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public Product getProductById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Product.class);
    }

    @Override
    public Product getProductByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Product.class);
    }

    @Override
    public String updateProduct(Product product) {
        Query query = new Query(Criteria.where("_id").is(product.getId()));
        Update update = new Update().set("publisher", product.getPublisher())
                .set("info", product.getInfo())
                .set("updateTime", new Date());
        return "success";
    }

    @Override
    public String deleteProduct(Product product) {
        mongoTemplate.remove(product);
        return "success";
    }

    @Override
    public String deleteProductById(String id) {
        //findOne
        Product product = getProductById(id);
        //delete
        deleteProduct(product);
        return "success";
    }
}
