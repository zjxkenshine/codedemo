package com.kenshine.demo01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/19 10:04
 * @description：
 * @modified By：
 * @version: $
 */
public class User {
    private String name;
    private String surname;
    private Integer age;

    public User() {
        super();
    }

    public User(String name, String surname, Integer age) {
        super();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @WebExposed
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @WebExposed
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
