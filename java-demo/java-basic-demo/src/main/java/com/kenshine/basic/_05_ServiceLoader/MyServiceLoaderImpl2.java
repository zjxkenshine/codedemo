package com.kenshine.basic._05_ServiceLoader;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 20:04
 * @description：
 * @modified By：
 * @version: $
 */
public class MyServiceLoaderImpl2 implements MyServiceLoader{
    @Override
    public String sayHello() {
        return "hello2";
    }
    @Override
    public String getName() {
        return "name2";
    }
}
