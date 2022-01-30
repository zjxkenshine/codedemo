package com.kenshine.designpattern.gof09_Bridge.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/30 12:10
 * @description：
 * @modified By：
 * @version: $
 */
public abstract class Car {
    private Tyre tyre;
    // 安装轮胎
    public void setTyre(Tyre tyre){
        this.tyre = tyre;
    }

    // 运行
    public void run(){
        System.out.println("轮胎"+tyre.getType()+"炸了");
    }

}
