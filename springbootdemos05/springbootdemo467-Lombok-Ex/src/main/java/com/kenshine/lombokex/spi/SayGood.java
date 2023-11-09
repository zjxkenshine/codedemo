package com.kenshine.lombokex.spi;

import com.github.houbb.lombok.ex.annotation.SPIAuto;

/**
 * @author kenshine
 * 自动spi注册
 */
//@SPIAuto("good")
public class SayGood implements Say{

    @Override
    public void say() {
        System.out.println("good");
    }

}