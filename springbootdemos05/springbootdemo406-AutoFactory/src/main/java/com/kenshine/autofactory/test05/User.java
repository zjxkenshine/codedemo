package com.kenshine.autofactory.test05;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import com.google.inject.name.Named;
import lombok.ToString;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户
 * @Date 2023-10-24 9:15
 * @modified By：
 * @version: 1.0$
 */
@ToString
@AutoFactory
public class User {
    private Integer id;
    private String name;

    public User(@Provided @Named("uid") Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
