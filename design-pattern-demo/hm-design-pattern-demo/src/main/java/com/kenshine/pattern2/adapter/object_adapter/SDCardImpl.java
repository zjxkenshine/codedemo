package com.kenshine.pattern2.adapter.object_adapter;

/**
 * @version v1.0
 * @ClassName: SDCardImpl
 * @Description: 具体的SD卡
 * @Author: kenshine
 */
public class SDCardImpl implements SDCard {

    @Override
    public String readSD() {
        String msg = "SDCard read msg ： hello word SD";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg ：" + msg);
    }
}
