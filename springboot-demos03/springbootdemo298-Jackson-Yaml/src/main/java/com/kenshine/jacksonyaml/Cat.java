package com.kenshine.jacksonyaml;

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
    private List<String> hobbies;
    private Map<String, String> map;
}