package com.kenshine.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author by kenshine
 * @Classname Test
 * @Description SPI测试
 * @Date 2023-10-18 12:33
 * @modified By：
 * @version: 1.0$
 */
public class SpiTest {

    @Test
    public void testSPI() {
        // ServiceLoader
        ServiceLoader<HelloInterface> serviceLoader = ServiceLoader.load(HelloInterface.class);
        for (HelloInterface hello: serviceLoader) {
            hello.sayHello();
        }
    }
}
