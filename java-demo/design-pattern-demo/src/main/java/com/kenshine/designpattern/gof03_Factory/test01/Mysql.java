package com.kenshine.designpattern.gof03_Factory.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 0:46
 * @description：
 * @modified By：
 * @version: $
 */
public class Mysql implements DataBase{
    @Override
    public void open() {
        System.out.println("open mysql");
    }

    @Override
    public void close() {
        System.out.println("close mysql");
    }
}
