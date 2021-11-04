package com.kenshine.pattern.factory.config_factory;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 简单工厂+配置文件
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        coffee.addMilk();
        coffee.addsugar();
        System.out.println(coffee.getName());

        System.out.println("=============");
        Coffee latte = CoffeeFactory.createCoffee("latte");
        System.out.println(latte.getName());
    }
}
