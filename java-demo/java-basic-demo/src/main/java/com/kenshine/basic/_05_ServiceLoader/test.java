package com.kenshine.basic._05_ServiceLoader;

import java.util.ServiceLoader;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 20:06
 * @description：
 * @modified By：
 * @version: $
 */
public class test {
    public static void main(String[] args) {
        //resources\META-INF\services下，文件名要与全限定类名相同
        ServiceLoader<MyServiceLoader> serviceLoader = ServiceLoader.load(MyServiceLoader.class);
        //使用迭代查找服务
        for (MyServiceLoader myServiceLoader : serviceLoader) {
            System.out.println(myServiceLoader.getName() + myServiceLoader.sayHello());
        }
    }
}
