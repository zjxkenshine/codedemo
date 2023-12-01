package com.kenshine.objcompare.model;

import javafx.scene.Parent;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname User
 * @Description 测试类
 * @Date 2023-12-01 18:38
 * @modified By：
 * @version: 1.0$
 */
//@Data
public class User{
    private String id;

    private String username;

    private String password;

    private String sex;

    private Parent parent;

    private String tag;

    private String attribute;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
