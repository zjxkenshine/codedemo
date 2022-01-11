package com.kenshine.designpattern.gof04_FactoryMethod.test01.factory;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 23:07
 * @description：
 * @modified By：
 * @version: $
 */
public class AmericanFoodFactory implements FoodFactory{
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new AmericanFoodA();
        } else if (name.equals("B")) {
            return new AmericanFoodB();
        } else {
            return null;
        }
    }
}
