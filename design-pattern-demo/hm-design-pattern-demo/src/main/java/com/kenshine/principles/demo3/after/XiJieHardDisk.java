package com.kenshine.principles.demo3.after;

/**
 * @version v1.0
 * @ClassName: XiJieHardDisk
 * @Description: 希捷硬盘
 * @Author: 黑马程序员
 */
public class XiJieHardDisk implements HardDisk {

    //存储数据的方法
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据为：" + data);
    }

    //获取数据的方法
    public String get() {
        System.out.println("使用希捷希捷硬盘取数据");
        return "数据";
    }
}
