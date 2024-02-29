package com.kenshine.joddjson.model;

import jodd.json.meta.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 * @author kenshine
 * JSON注释
 * strict模式只包含有JSON注释的字段
 */
@Data
@JSON(strict = true)
public class Person2 {
    @JSON
    private String name;
    @JSON(name = "home_address")
    private String home;
    private String work;
    @JSON
    private Integer age;
    @JSON
    private List<String> phones = new ArrayList<String>();
}