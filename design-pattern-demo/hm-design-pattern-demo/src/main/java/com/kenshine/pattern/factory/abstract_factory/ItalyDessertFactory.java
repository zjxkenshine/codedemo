package com.kenshine.pattern.factory.abstract_factory;

/**
 * @version v1.0
 * @ClassName: ItalyDessertFactory
 * @Description:
 *
 *      意大利风味甜品工厂
 *          生产拿铁咖啡和提拉米苏甜品
 * @Author: 黑马程序员
 */
public class ItalyDessertFactory implements DessertFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
