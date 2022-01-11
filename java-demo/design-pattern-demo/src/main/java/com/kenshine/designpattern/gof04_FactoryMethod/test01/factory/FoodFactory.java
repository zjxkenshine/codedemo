package com.kenshine.designpattern.gof04_FactoryMethod.test01.factory;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 23:02
 * @description：工厂接口
 * @modified By：
 * @version: $
 */
public interface FoodFactory {
    //工厂方法
    Food makeFood(String name);
}
