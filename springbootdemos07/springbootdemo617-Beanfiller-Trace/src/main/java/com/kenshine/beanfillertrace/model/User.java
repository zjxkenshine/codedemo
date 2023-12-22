package com.kenshine.beanfillertrace.model;

import io.github.beanfiller.annotation.annotations.Value;
import io.github.beanfiller.annotation.annotations.Var;
import lombok.Data;
import org.cornutum.tcases.TestCase;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户类
 * @Date 2023-12-22 9:52
 * @modified By：
 * @version: 1.0$
 */
@Data
public class User {
    @Var(value = {@Value("1"), @Value("2"), @Value("3"), @Value("4"), @Value("5")})
    private Integer id;
    // value不能重复
    @Var(value = {@Value("kenshine"), @Value("lin"), @Value("qin"),
            @Value(value ="4", type = TestCase.Type.FAILURE) ,
            @Value(value ="8",type = TestCase.Type.FAILURE)})
    private String name;
}
