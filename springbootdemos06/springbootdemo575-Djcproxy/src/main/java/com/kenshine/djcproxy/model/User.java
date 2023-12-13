package com.kenshine.djcproxy.model;

import lombok.Data;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户类
 * @Date 2023-12-13 8:50
 * @modified By：
 * @version: 1.0$
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
