package com.kenshine.pattern2.adapter.object_adapter;

/**
 * @version v1.0
 * @ClassName: TFCardImpl
 * @Description: TF卡对象
 * @Author: kenshine
 */
public class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        String msg = "TFCard read msg ： hello word TFcard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg :" + msg);
    }
}
