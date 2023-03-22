package com.kenshine.junrar;

/**
 * @author by kenshine
 * @Classname MainTest
 * @Description 测试 监控解压进度
 * @Date 2023/3/22 14:14
 * @modified By：
 * @version: 1.0$
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        System.out.println("unrar result:"+UnRarDemo.unrar("D:\\Setups\\RA-1.2.1.0.rar","D:\\Setups\\RA-1.2.1.0\\"));
    }
}
