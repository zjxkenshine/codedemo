package com.kenshine.querydsl.entity;

import javax.persistence.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 23:19
 * @description：人
 * @modified By：
 * @version: $
 */
@Entity
@Table(name="people")
public class People {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="address")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
