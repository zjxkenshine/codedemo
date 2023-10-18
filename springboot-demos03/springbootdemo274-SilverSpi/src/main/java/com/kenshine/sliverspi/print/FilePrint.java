package com.kenshine.sliverspi.print;

/**
 * 打印到文件
 */
public class FilePrint implements IPrint {
    @Override
    public void print(String str) {
        System.out.println("file print: " + str);
    }
}
