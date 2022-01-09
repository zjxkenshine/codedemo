package com.kenshine.designpattern.gof03_factory.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 0:48
 * @description：
 * @modified By：
 * @version: $
 */
public class Oracle implements DataBase{
    @Override
    public void open() {
        System.out.println("open oracle");
    }

    @Override
    public void close() {
        System.out.println("close oracle");
    }
}
