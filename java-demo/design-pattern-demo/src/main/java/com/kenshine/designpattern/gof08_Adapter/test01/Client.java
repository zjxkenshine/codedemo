package com.kenshine.designpattern.gof08_Adapter.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/28 15:14
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        Ps2 p = new Adapter();
        p.isPs2();
    }
}
