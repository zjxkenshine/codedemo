package com.kenshine.pattern2.adapter.object_adapter;


/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 对象适配器模式
 * @Author: kenshine
 *
 * 对象适配器使用聚合操作TF卡
 *
 * 第三种方法，接口适配器模式
 * 抽象类实现adapter,实现某些需要的方法，略
 */
public class Client {
    public static void main(String[] args) {
        //创建计算机对象
        Computer computer = new Computer();
        //读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("===============");
        //使用该电脑读取TF卡中的数据
        //创建适配器类对象
        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        String msg1 = computer.readSD(sdAdapterTF);
        System.out.println(msg1);
    }
}
