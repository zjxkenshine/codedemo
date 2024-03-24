package com.kenshine.jacksonxml;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 支持Jackson提供的用于注释pojo的所有注释
 */
@Data
@AllArgsConstructor
@JsonPropertyOrder({"age", "id", "name"})
public class Person {
    @JsonProperty("_id")
    private Integer id;

    private String name;

    private int age;

    @JsonIgnore
    private String note;
}