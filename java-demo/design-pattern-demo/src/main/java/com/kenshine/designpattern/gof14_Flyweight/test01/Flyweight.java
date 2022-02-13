package com.kenshine.designpattern.gof14_Flyweight.test01;

public abstract class Flyweight {
    private String intrinsic;
    // 外部状态
    protected final String Extrinsic;

    // 要求享元角色必须接受外部状态
    public Flyweight(String extrinsic) {
        Extrinsic = extrinsic;
    }

    // 定义业务操作
    public abstract void operate();

    // 内部状态的getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}