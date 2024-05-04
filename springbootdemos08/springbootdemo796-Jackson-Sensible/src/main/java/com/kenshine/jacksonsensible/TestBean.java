package com.kenshine.jacksonsensible;

import idea.verlif.jackson.sensible.anno.Sensitive;
import idea.verlif.jackson.sensible.anno.Strategy;
import lombok.Data;

import java.io.Serializable;

/**
 * @author by kenshine
 * @Classname TestBean
 * @Description 测试Bean
 * @Date 2024-05-04 14:32
 * @modified By：
 * @version: 1.0$
 */
@Data
public class TestBean implements Serializable {
    @Sensitive(strategy = Strategy.ALWAYS_NULL)
    private String alwaysNull;

    @Sensitive
    private String stringHandler;

    @Sensitive
    private int intValue;

    @Sensitive(strategy = Strategy.ALWAYS_VALUE, value = "123")
    private Integer integerValue;

    @Sensitive
    private Double longValue;

}
