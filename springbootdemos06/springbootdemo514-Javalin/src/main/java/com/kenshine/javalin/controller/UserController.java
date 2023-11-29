package com.kenshine.javalin.controller;

import com.kenshine.javalin.model.User;
import io.javalin.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname UserController
 * @Description 测试Controller
 * @Date 2023-11-29 11:51
 * @modified By：
 * @version: 1.0$
 */
public class UserController {
    public static void getAllUsers(Context context) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("name"+i);
            user.setSex("男");
            user.setAge(10+i);
            users.add(user);
        }
        context.json(users);
    }

    public static void createUser(Context context) {
        User user = context.bodyAsClass(User.class);
        context.json(user);
    }

    public static void getUser(Context context) {
        //获取id
        String id = context.pathParam("id");
        User user = new User();
        user.setName("name");
        user.setSex("男");
        user.setAge(10);
        context.json(user);
    }

    public static void updateUser(Context context) {
        //获取id
        String id = context.pathParam("id");
        context.result(id+" 更新成功了");
    }

    public static void deleteUser(Context context) {
        //获取id
        String id = context.pathParam("id");
        context.result(id+" 删除成功了");
    }
}
