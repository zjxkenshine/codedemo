package com.kenshine.fluentvalidator.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author kenshine
 * jsr-303支持
 */
@Data
public class Department {
    @NotNull
    private Integer id;

    @Length(max = 30)
    private String name;
}