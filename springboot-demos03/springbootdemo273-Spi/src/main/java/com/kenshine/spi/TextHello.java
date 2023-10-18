package com.kenshine.spi;

public class TextHello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("text hello");
    }
}