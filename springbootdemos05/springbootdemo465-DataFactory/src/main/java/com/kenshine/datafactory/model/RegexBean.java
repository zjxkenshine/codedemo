package com.kenshine.datafactory.model;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 正则表达式支持
 * @author kenshine
 */
@Data
public class RegexBean {

    @DataFactory(regex = "[0-3]([a-c]|[e-g]{1,2})")
    private String name;

    @DataFactory(regex = "[0-9]{1,2}")
    private int age;

    @DataFactory(regex = "[0-9]{1,2}")
    private BigDecimal amount;
}