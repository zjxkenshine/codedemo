package com.kenshine.staxmate.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshine
 */
@Data
public class Vegetable {
    private String name;
    private final List<String> preparations = new ArrayList<>();
}