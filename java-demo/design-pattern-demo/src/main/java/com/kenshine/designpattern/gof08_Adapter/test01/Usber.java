package com.kenshine.designpattern.gof08_Adapter.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/28 15:12
 * @description：
 * @modified By：
 * @version: $
 */
public class Usber implements Usb {
    @Override
     public void isUsb() {
        System.out.println("USB接口");
     }

}
