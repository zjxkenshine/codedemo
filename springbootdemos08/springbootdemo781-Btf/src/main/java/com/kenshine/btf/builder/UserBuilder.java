package com.kenshine.btf.builder;

import com.github.fge.Builder;

/**
 * @author by kenshine
 * @Classname UserBuilder
 * @Description 创建者模式
 * @Date 2024-04-19 15:54
 * @modified By：
 * @version: 1.0$
 *
 */
public class UserBuilder implements Builder<User> {
    @Override
    public User build() {
        User user = new User();
        user.setId(1);
        user.setName("kenshine");
        return user;
    }
}
