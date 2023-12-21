package com.kenshine.jasper.model;

import java.io.Serializable;

/**
 * @author kenshine
 * 子报表
 */
public class SubEntity implements Serializable {
    private String name;
    private String price;
    private Integer amount;

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPrice() {
        return price;
    }
 
    public void setPrice(String price) {
        this.price = price;
    }
 
    public Integer getAmount() {
        return amount;
    }
 
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}