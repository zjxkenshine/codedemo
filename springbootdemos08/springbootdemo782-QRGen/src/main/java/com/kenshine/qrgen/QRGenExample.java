package com.kenshine.qrgen;


import net.glxn.qrgen.javase.QRCode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author by kenshine
 * @Classname QRGenExample
 * @Description QRGen使用示例
 * @Date 2024-04-19 16:35
 * @modified By：
 * @version: 1.0$
 */
public class QRGenExample {
    public static void main(String[] args) throws FileNotFoundException {
        QRCode.from("www.kenshine.com").withSize(250, 250).withColor(30, 90).svg(new FileOutputStream("springbootdemo782-QRGen\\test.svg"));
    }
}
