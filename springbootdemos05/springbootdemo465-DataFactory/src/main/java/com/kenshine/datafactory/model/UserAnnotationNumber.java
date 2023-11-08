package com.kenshine.datafactory.model;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author kenshine
 * DataFactory注解配置规则
 */
@Data
public class UserAnnotationNumber {

    @DataFactory(min = 10, max = 20)
    private Byte aByte;

    @DataFactory(min = 10, max = 20)
    private Short aShort;

    @DataFactory(min = 10, max = 20)
    private Integer integer;

    @DataFactory(min = 10, max = 20)
    private Long aLong;

    // precision精度
    @DataFactory(min = 10, max = 20, precision = 3)
    private Double aDouble;

    @DataFactory(min = 10, max = 20, precision = 3)
    private Float aFloat;

    @DataFactory(min = 10, max = 20, precision = 3)
    private BigDecimal bigDecimal;

    @DataFactory(min = 10, max = 20)
    private BigInteger bigInteger;

}