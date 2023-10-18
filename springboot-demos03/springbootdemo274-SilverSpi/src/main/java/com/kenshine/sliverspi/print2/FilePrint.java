package com.kenshine.sliverspi.print2;

/**
 * @author by kenshine
 * @Classname FilePrint
 * @Description 文件打印
 * @Date 2023-10-18 13:41
 * @modified By：
 * @version: 1.0$
 */
public class FilePrint implements IPrint {
    @Override
    public void print(String str) {
        System.out.println("console print: " + str);
    }

    @Override
    public void adaptivePrint(String conf, String str) {
        System.out.println("console adaptivePrint: " + str);
    }
}
