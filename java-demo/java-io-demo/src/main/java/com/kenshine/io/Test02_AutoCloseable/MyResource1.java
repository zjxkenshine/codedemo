package com.kenshine.io.Test02_AutoCloseable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 20:43
 * @description：
 * @modified By：
 * @version: $
 */
public class MyResource1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("MyResource1关闭了");
    }
}
