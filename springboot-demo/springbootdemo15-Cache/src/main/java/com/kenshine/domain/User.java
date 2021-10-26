package com.kenshine.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 8:45
 * @description：用户类
 * @modified By：
 * @version: $
 */
@Entity
@Table(name="user")
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

}
