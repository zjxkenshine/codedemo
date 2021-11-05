package com.kenshine.pattern2.decorator;

/**
 * @version v1.0
 * @ClassName: Egg
 * @Description: 培根类(具体的装饰者角色)
 * @Author: kenshine
 */
public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(fastFood,2,"培根");
    }

    @Override
    public float cost() {
        //计算价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
