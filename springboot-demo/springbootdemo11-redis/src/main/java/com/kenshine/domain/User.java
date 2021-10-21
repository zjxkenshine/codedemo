package com.kenshine.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 14:27
 * @description：用户类
 * @modified By：
 * @version: $
 */
@Data
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

}

