package com.kenshine.fly.entity;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 17:05
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
public class User {
    private String id;
    private String name;
    private Integer age;
    private String email;
}
