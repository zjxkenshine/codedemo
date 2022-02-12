package com.kenshine.designpattern.gof12_Decorator.test01.house;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 21:04
 * @description：小房子
 * @modified By：
 * @version: $
 */
public class SmallHouse implements House{
    @Override
    public void output() {
        System.out.println("这是小房子");
    }
}
