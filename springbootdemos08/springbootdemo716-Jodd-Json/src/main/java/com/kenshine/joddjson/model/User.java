package com.kenshine.joddjson.model;

import lombok.Data;

import java.util.Map;

/**
 * @author kenshine
 * 测试解析
 */
@Data
public class User {
    private String name;
    private Map<String, Bar> bars;
    private Map<String, Inter> inters;
}

