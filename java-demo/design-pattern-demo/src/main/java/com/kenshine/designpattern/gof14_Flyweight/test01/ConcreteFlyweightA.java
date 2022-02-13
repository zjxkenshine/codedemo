package com.kenshine.designpattern.gof14_Flyweight.test01;

public class ConcreteFlyweightA extends Flyweight {
    // 接受外部状态
    public ConcreteFlyweightA(String extrinsic) {
        super(extrinsic);
    }

    // 根据外部状态进行逻辑处理
    @Override
    public void operate() {
        System.out.println("ConcreteFlyweightA");
    }
}