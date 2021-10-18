package com.kenshine.pattern.factory.static_factory;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 22:31
 * @description：简单工厂类，提供了一个方法专门生成coffee
 * @modified By：
 * @version: 1.0$
 *
 * 仅需要将工厂方法设置成静态即可
 * 好处：不用重复创建对象
 */
public class SimpleCoffeeFactory {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        }
        return coffee;
    }

}
