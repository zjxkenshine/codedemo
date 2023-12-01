package com.kenshine.objcompare.model;

import com.kenshine.objcompare.annotation.Snapshoted;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Item
 * @Description 过滤属性
 * @Date 2023-12-01 18:58
 * @modified By：
 * @version: 1.0$
 */
//@Data
public class Item {
    private Long id;
    @Snapshoted
    private String name;
    @Snapshoted
    private String url;
    private int stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
