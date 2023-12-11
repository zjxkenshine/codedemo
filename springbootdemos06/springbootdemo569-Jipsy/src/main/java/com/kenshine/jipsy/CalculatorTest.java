package com.kenshine.jipsy;

import com.kenshine.jipsy.inter.Calculator;

import java.util.ServiceLoader;

/**
 * @author by kenshine
 * @Classname CalculatorTest
 * @Description spi使用测试
 * @Date 2023-12-11 17:06
 * @modified By：
 * @version: 1.0$
 */
public class CalculatorTest {

    public static void main(String[] args) {
        // 服务发现
        ServiceLoader<Calculator> serviceLoader = ServiceLoader.load(Calculator.class);
        for (Calculator search : serviceLoader){
            double sum = search.add(1,2);
            System.out.println(sum);
        }
    }
}
