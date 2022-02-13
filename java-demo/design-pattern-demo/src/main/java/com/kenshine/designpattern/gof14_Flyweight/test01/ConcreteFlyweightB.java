package com.kenshine.designpattern.gof14_Flyweight.test01;

/**
 * 非享元类
 */
public class ConcreteFlyweightB extends Flyweight {
    // 接受外部状态
    public ConcreteFlyweightB(String extrinsic) {
        super(extrinsic);
    }

    // 根据外部状态进行逻辑处理
    @Override
    public void operate() {
        System.out.println("ConcreteFlyweightA");
    }
}