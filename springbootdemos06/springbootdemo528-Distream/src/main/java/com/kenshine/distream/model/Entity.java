package com.kenshine.distream.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/3 13:39
 * @description：测试
 * @modified By：
 * @version: $
 */
public class Entity {
    private String name;
    private Double value;
    private Double percent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Entity(String name, Double value) {
        this.name = name;
        this.value = value;
    }
}
