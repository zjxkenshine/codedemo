package com.kenshine.jpa.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 11:08
 * @description：用户2
 * @modified By：
 * @version: $
 */
@Data
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

}
