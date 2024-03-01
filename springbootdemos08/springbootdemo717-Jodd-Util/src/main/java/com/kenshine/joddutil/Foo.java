package com.kenshine.joddutil;

import lombok.ToString;

/**
 * @author kenshine
 * 测试类
 */
@ToString
public class Foo {
    private String readwrite;
    private String readonly;

    public String getReadwrite() {
        return readwrite;
    }

    public void setReadwrite(String readwrite) {
        this.readwrite = readwrite;
    }

    public String getReadonly() {
        return readonly;
    }
}