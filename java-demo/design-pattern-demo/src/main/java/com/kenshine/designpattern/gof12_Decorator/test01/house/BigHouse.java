package com.kenshine.designpattern.gof12_Decorator.test01.house;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 21:03
 * @description：
 * @modified By：
 * @version: $
 */
public class BigHouse implements House{
    @Override
    public void output() {
        System.out.println("这是大房子");
    }
}
