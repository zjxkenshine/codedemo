package com.kenshine.designpattern.gof09_Bridge.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/30 12:12
 * @description： 轮胎类型A
 * @modified By：
 * @version: $
 */
public class TyreA implements Tyre{
    @Override
    public String getType() {
        return "A";
    }
}
