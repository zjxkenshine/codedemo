package com.kenshine.graphql.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String nickname;
    private String mail;
    private String password;
    private String description;
    private String updateTime;
    private String createTime;
}
