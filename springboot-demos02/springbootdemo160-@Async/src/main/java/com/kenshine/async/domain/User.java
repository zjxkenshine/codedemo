package com.kenshine.async.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 11:11
 * @description：用户
 * @modified By：
 * @version: $
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //创建时间
    private Date created;

}
