package com.kenshine.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:29
 * @description：用户类
 * @modified By：
 * @version: $
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

}
