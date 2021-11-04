package com.kenshine.pattern.factory.factory_method;

import com.kenshine.pattern.factory.static_factory.SimpleCoffeeFactory;

/**
 * @version v1.0
 * @ClassName: CoffeeStore
 * @Description: 咖啡店
 * @Author: 黑马程序员
 */
public class CoffeeStore {
    private CoffeeFactory factory;

    public void setCoffeeFactory(CoffeeFactory factory){
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addsugar();
        return coffee;
    }
}
