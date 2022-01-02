package com.kenshine.starter.service;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 16:17
 * @description：
 * @modified By：
 * @version: $
 */
public class TestService {
    private String user;

    private String password;

    private String salt;

    public TestService(String user, String password, String salt) {
        this.user = user;
        this.password = password;
        this.salt = salt;
    }

    public String show() {
        return this.user + "--" + this.password + "--" + this.salt;
    }

}
