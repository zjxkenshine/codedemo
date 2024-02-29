package com.kenshine.joddjson.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 * @author kenshine
 */
@Data
public class Person {
    private String name;
    private String home;
    private String work;
    private List<String> phones = new ArrayList<String>();
}