package com.kenshine.staxmate.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * @author kenshine
 */
@Data
public class Food {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Vegetable> vegetables = new ArrayList<>();
}