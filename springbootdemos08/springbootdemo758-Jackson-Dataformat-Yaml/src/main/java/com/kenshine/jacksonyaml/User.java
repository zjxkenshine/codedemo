package com.kenshine.jacksonyaml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String name;
    private Integer age;
    private List<String> hobbies;
    private Map<String, String> map;
}