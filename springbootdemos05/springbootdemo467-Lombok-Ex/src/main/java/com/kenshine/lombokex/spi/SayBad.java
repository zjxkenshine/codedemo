package com.kenshine.lombokex.spi;

import com.github.houbb.lombok.ex.annotation.SPIAuto;

/**
 * @author kenshine
 * 自动spi注册
 */
//@SPIAuto("bad")
public class SayBad implements Say{
    @Override
    public void say() {
        System.out.println("bad");
    }
}