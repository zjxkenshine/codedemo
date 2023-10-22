package com.kenshine.yamlbeans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String name;
    private Integer age;
    private List<String> list;
    private Map<String, String> map;
}
