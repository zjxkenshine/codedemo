package com.kenshine.pattern2.adapter.class_adapter;

/**
 * @version v1.0
 * @ClassName: Computer
 * @Description: 电脑
 * @Author: kenshine
 */
public class Computer {

    /**
     *  从SD卡中读取数据
     */
    public String readSD(SDCard sdCard) {
        if(sdCard == null) {
            throw  new NullPointerException("sd card is null");
        }
        return sdCard.readSD();
    }
}
