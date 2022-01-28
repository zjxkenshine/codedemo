package com.kenshine.designpattern.gof08_Adapter.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/28 15:13
 * @description：
 * @modified By：
 * @version: $
 * 类适配器
 * 通过继承的方式来适配不同接口
 */
public class Adapter extends Usber implements Ps2 {
    @Override
    public void isPs2() {
        isUsb();
    }
}
