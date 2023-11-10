package com.kenshine.domain;

import com.kenshine.annotation.SensitiveEntryCustom;

import java.util.List;

/**
 * @author by kenshine
 * @Classname CustomUserEntryObject
 * @Description 自定义级联注解使用
 * @Date 2023-11-10 11:51
 * @modified By：
 * @version: 1.0$
 */
public class CustomUserEntryObject {
    @SensitiveEntryCustom
    private User user;

    @SensitiveEntryCustom
    private List<User> userList;

    @SensitiveEntryCustom
    private User[] userArray;
}
