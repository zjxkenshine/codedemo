package com.kenshine.pattern2.adapter.class_adapter;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 客户端类
 * @Author: kenshine
 *
 * 类适配器模式，违背了合成复用原则，客户类有一个接口规范的情况下可用，反之不可用
 * 推荐使用对象适配器模式
 */
public class Client {
    public static void main(String[] args) {
        //创建计算机对象
        Computer computer = new Computer();
        //读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("===============");
        //使用该电脑读取TF卡中的数据 通过适配器类
        //定义适配器类
        String msg1 = computer.readSD(new SDAdapterTF());
        System.out.println(msg1);
    }
}
