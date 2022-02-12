package com.kenshine.designpattern.gof12_Decorator.test01;

import com.kenshine.designpattern.gof12_Decorator.test01.house.House;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 21:02
 * @description：装饰器
 * @modified By：
 * @version: $
 */
public class Decorator implements House{
    private House house;
    public Decorator(House house){
        this.house = house;
    }
    
    @Override
    public void output() {
        System.out.println("这是针对房子的前段装饰增强");
        house.output();
        System.out.println("这是针对房子的后段装饰增强");
    }
}
