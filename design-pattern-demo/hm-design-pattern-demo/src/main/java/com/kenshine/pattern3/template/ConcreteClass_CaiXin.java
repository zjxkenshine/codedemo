package com.kenshine.pattern3.template;

/**
 * @version v1.0
 * @ClassName: ConcreteClass_BaoCai
 * @Description: 炒菜心类
 * @Author: kenshine
 */
public class ConcreteClass_CaiXin extends AbstractClass {

    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是蒜蓉");
    }
}
