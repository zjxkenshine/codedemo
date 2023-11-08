package com.kenshine.datafactory.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private String name;

    private int age;

    private Date birthday;

    private List<String> stringList;

    private StatusEnum statusEnum;

    private Map<String, String> map;
}