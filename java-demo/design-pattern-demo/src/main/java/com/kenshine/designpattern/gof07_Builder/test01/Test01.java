package com.kenshine.designpattern.gof07_Builder.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/26 12:44
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {
    public static void main(String[] args) {
        //也通过Computer静态方法来创建Builder
        Computer computer=new Computer.Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer);
    }
}
