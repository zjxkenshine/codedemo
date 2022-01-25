package com.kenshine.designpattern.gof06_ConfigFactory.test01;

import com.kenshine.designpattern.gof06_ConfigFactory.test01.domain.Car;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 19:53
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {

    public static void main(String[] args) {
        Car car = CarFactory.getInstance().getCar("benz");
        car.move();
    }

}
