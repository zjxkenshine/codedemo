package com.kenshine.csv.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 集合类测试
 */
@Data
public class UserCollection {

    private String[] arrays;

    private LinkedList<String> lists;

    private Map<String, String> maps;

    private Set<String> sets;

}