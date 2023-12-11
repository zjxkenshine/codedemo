package com.kenshine.jipsy.impl;

import com.kenshine.jipsy.inter.Calculator;
import org.kordamp.jipsy.annotations.ServiceProviderFor;

/**
 * @author by kenshine
 * @Classname BasicCalculator
 * @Description 实现类
 * @Date 2023-12-11 17:02
 * @modified By：
 * @version: 1.0$
 */
@ServiceProviderFor(Calculator.class)
public class BasicCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        System.out.println("执行add");
        return a+b;
    }
}
