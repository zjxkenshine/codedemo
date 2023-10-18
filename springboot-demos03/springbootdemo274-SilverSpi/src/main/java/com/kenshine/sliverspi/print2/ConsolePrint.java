package com.kenshine.sliverspi.print2;

public class ConsolePrint implements IPrint {

    @Override
    public void print(String str) {
        System.out.println("console print: " + str);
    }

    @Override
    public void adaptivePrint(String conf, String str) {
        System.out.println("console adaptivePrint: " + str);
    }
}