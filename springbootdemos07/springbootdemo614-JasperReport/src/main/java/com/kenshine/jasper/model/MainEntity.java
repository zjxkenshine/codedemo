package com.kenshine.jasper.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname MainEntity
 * @Description 父报表
 * @Date 2023-12-21 17:46
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */public class MainEntity implements Serializable {
    private String product;
    private String category;
    private List<SubEntity> subData;
    // setter and getter

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<SubEntity> getSubData() {
        return subData;
    }

    public void setSubData(List<SubEntity> subData) {
        this.subData = subData;
    }
}
