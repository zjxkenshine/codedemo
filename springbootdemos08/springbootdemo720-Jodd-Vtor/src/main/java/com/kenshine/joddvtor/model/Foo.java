package com.kenshine.joddvtor.model;

import jodd.vtor.constraint.MinLength;
import lombok.Data;

/**
 * @author kenshine
 * 校验注解简化使用
 */
@Data
public class Foo {
    @MinLength(2)
    private String boo;
}