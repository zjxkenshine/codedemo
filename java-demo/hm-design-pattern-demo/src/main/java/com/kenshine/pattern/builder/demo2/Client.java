package com.kenshine.pattern.builder.demo2;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 * @Author: 黑马程序员
 *
 * 工厂方法模式注重的是整体对象的创建方式；而建造者模式注重的是部件构建的过程，意在通过一步一步地精确构造创建出一个复杂的对象。
 *
 * 抽象工厂生产产品族，建造者是生产零件
 *
 */
public class Client {
    public static void main(String[] args) {
        //创建手机对象   通过构建者对象获取手机对象
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .mainboard("华硕主板")
                .build();

        System.out.println(phone);
    }
}
