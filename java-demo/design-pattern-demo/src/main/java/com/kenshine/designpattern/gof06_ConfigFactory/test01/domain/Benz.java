package com.kenshine.designpattern.gof06_ConfigFactory.test01.domain;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 19:48
 * @description：
 * @modified By：
 * @version: $
 */
public class Benz implements Car{

    @Override
    public void move() {
        System.out.println("Benz has moved");
    }

}