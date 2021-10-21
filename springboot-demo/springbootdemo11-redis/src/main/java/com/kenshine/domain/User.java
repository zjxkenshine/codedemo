package com.kenshine.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 14:27
 * @description：用户类
 * @modified By：
 * @version: $
 *
 * 开启缓存需要实现序列化接口
 */
@Data
@ToString
@Entity
public class User implements Serializable {

    //IllegalArgumentException: DefaultSerializer requires a Serializable payload
    // but received an object of type [com.syc.redis.domain.User]

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

}

