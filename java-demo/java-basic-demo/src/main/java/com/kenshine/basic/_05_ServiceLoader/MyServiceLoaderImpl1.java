package com.kenshine.basic._05_ServiceLoader;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 20:03
 * @description：
 * @modified By：
 * @version: $
 */
public class MyServiceLoaderImpl1 implements MyServiceLoader{
    @Override
    public String sayHello() {
        return "hello1";
    }
    @Override
    public String getName() {
        return "name1";
    }
}
