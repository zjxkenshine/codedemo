package com.kenshine.pattern.factory.factory_method;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 23:35
 * @description：拿铁咖啡工厂
 * @modified By：
 * @version: $
 */
public class LatteCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
