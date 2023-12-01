package com.kenshine.objcompare.model;

/**
 * @author by kenshine
 * @Classname RecycleUser
 * @Description
 * @Date 2023-12-01 19:05
 * @modified By：
 * @version: 1.0$
 */
public class RecycleUser {
    private RecycleUser user;

    private String name;

    private String password;

    public RecycleUser getUser() {
        return user;
    }

    public void setUser(RecycleUser user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
