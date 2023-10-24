package com.kenshine.autofactory.test01;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import lombok.ToString;

/**
 * @author kenshine
 *
 * 使用@AutoFactory注释Phone类并使用@Provided注释其构造函数参数
 */
@AutoFactory
@ToString
public class Phone {

    private final Integer id;

    private final String name;

    Phone(@Provided Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}