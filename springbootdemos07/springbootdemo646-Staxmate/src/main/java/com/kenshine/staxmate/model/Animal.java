package com.kenshine.staxmate.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshine
 */
@Data
public class Animal {

    private String name;

    private final List<Meat> meats = new ArrayList<>();
}