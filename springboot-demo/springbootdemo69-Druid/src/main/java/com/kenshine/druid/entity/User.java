package com.kenshine.druid.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 23:47
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class User {

    private Long id;

    private String username;

    private String password;

}
