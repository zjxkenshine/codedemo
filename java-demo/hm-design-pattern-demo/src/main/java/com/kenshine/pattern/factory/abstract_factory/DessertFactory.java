package com.kenshine.pattern.factory.abstract_factory;

/**
 * @version v1.0
 * @ClassName: DessertFactory
 * @Description: 甜点工厂接口
 * @Author: 黑马程序员
 */
public interface DessertFactory {

    /**生产咖啡的功能  */
    Coffee createCoffee();

    /**生产甜品的功能  */
    Dessert createDessert();
}
