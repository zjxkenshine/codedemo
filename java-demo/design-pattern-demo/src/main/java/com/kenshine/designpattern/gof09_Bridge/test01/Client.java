package com.kenshine.designpattern.gof09_Bridge.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/30 12:07
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        // 宝马使用A类型轮胎
        Car car = new BMW();
        car.setTyre(new TyreA());
        car.run();

        // 奔驰使用B类型轮胎
        Car car1 = new Benz();
        car1.setTyre(new TyreB());
        car1.run();
    }
}
