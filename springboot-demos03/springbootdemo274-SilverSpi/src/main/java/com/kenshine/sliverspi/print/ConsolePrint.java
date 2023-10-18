package com.kenshine.sliverspi.print;

/**
 * 打印到控制台
 */
public class ConsolePrint implements IPrint {
    @Override
    public void print(String str) {
        System.out.println("console print: " + str);
    }
}