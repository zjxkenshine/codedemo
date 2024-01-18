package com.kenshine.jqwik.lifecycle;

import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

/**
 * @author by kenshine
 * @Classname SimpleLifecycleTests
 * @Description 生命周期示例
 * @Date 2024-01-18 10:39
 * @modified By：
 * @version: 1.0$
 */
public class SimpleLifecycleTests implements AutoCloseable{
    SimpleLifecycleTests() {
        System.out.println("Before each");
    }

    @Example
    void anExample() {
        System.out.println("anExample");
    }

    @Property(tries = 5)
    void aProperty(@ForAll String aString) {
        System.out.println("aProperty: " + aString);
    }

    @Override
    public void close() throws Exception {
        System.out.println("After each");
    }
}
