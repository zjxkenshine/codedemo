package com.kenshine.binder.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 13:55
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
public class User {
    private String name;

    private String password;

    private String email;

    private Date birthday;
}
