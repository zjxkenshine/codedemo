package com.kenshine.designpattern.gof03_Factory.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 0:50
 * @description：
 * @modified By：
 * @version: $
 */
public class SQLServer implements DataBase{

    @Override
    public void open() {
        System.out.println("open SQLServer");
    }

    @Override
    public void close() {
        System.out.println("close SQLServer");
    }
}
