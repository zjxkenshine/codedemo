package com.kenshine.designpattern.gof04_FactoryMethod.test01.factory;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 23:08
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {
    public static void main(String[] args) {
        // 先选择一个具体的工厂
        FoodFactory factory = new ChineseFoodFactory();
        // 由第一步的工厂产生具体的对象，不同的工厂造出不一样的对象
        Food food = factory.makeFood("A"); //  chineseFood * A
        System.out.println(food.getClass());
    }
}
