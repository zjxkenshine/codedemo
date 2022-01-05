package com.kenshine.io.Test02_AutoCloseable;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 20:44
 * @description：
 * @modified By：
 * @version: $
 */
public class MyResource2 implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("MyResource2关闭了");
        throw new IOException("出错了");
    }
}
