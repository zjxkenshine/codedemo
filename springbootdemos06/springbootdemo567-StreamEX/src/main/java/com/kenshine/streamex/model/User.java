package com.kenshine.streamex.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户
 * @Date 2023-12-11 13:11
 * @modified By：
 * @version: 1.0$
 */
@Data
@Accessors(chain = true)
public class User {
    private String name;
    private Role role;
}
