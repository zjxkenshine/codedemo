package com.kenshine.pattern.factory.factory_method;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 23:34
 * @description：咖啡抽象工厂
 * @modified By：
 * @version: 1.0$
 */
public interface CoffeeFactory {

    /**
     * 创建咖啡
     */
    Coffee createCoffee();

}
