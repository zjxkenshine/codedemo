package com.kenshine.mockdata;

import lombok.Data;

/**
 * @author by kenshine
 * @Classname Person
 * @Description 测试类
 * @Date 2024-05-13 11:37
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Person {
    private Pet pet;

    private double weight;
    private double height;

    private String name;
    private String address;
}
