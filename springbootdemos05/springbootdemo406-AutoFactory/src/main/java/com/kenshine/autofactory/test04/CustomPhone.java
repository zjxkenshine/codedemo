package com.kenshine.autofactory.test04;

import com.google.auto.factory.AutoFactory;
import lombok.Data;

/**
 * @author kenshine
 * 扩展接口
 *
 * extending 指定要继承的类
 */
@AutoFactory(extending = AbstractFactory.class)
@Data
public class CustomPhone {

    private final String brand;

    public CustomPhone(String brand) {
        this.brand = brand;
    }
}