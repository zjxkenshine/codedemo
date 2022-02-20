package com.kenshine.designpattern.gof15_Proxy.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/20 19:39
 * @description：测试类
 * @modified By：
 * @version: $
 * https://blog.csdn.net/i042416/article/details/81609948
 */
public class Client {
    public static void main(String[] args) {
        IDeveloper kenshine = new Developer("Kenshine");
        kenshine.writeCode();

        // 使用代理对象
        IDeveloper kenshine1 = new DeveloperProxy(kenshine);
        kenshine1.writeCode();
    }
}
