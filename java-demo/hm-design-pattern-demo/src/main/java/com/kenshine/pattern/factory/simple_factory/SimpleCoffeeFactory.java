package com.kenshine.pattern.factory.simple_factory;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 22:31
 * @description：简单工厂类，提供了一个方法专门生成coffee
 * @modified By：
 * @version: 1.0$
 */
public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        }
        return coffee;
    }

}
