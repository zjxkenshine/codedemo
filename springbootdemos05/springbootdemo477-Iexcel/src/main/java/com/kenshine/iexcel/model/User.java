package com.kenshine.iexcel.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 * @author Kenshine
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;

    /**
     * 构建用户
     * @return
     */
    public static List<User> buildUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User("kenshine",20));
        users.add(new User("excel",20));
        return users;
    }
}