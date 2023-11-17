package com.kenshine.javers.comparator;

import org.javers.core.diff.custom.CustomValueComparator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 自定义Javers比较器
 * @author Kenshine
 */
public class CustomBigDecimalComparator implements CustomValueComparator<BigDecimal> {
    private int significantDecimalPlaces;

    public CustomBigDecimalComparator(int significantDecimalPlaces) {
        this.significantDecimalPlaces = significantDecimalPlaces;
    }

    @Override
    public boolean equals(BigDecimal a, BigDecimal b) {
        return round(a).equals(round(b));
    }

    @Override
    public String toString(BigDecimal value) {
        return round(value).toString();
    }

    private BigDecimal round(BigDecimal val) {
        return val.setScale(significantDecimalPlaces, RoundingMode.HALF_DOWN);
    }
}
