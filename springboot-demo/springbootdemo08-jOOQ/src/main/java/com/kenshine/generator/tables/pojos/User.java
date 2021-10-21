/*
 * This file is generated by jOOQ.
 */
package com.kenshine.generator.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User implements Serializable {

    private static final long serialVersionUID = -643835919;

    private Integer id;
    private String  password;
    private String  username;

    public User() {}

    public User(User value) {
        this.id = value.id;
        this.password = value.password;
        this.username = value.username;
    }

    public User(
        Integer id,
        String  password,
        String  username
    ) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(id);
        sb.append(", ").append(password);
        sb.append(", ").append(username);

        sb.append(")");
        return sb.toString();
    }
}