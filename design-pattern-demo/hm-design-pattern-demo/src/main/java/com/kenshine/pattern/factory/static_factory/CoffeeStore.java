package com.kenshine.pattern.factory.static_factory;

/**
 * @version v1.0
 * @ClassName: CoffeeStore
 * @Description: 咖啡店
 * @Author: 黑马程序员
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        //调用生产咖啡的方法
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        //加配料
        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
