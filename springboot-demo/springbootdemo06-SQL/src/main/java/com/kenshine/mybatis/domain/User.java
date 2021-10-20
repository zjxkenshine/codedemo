package com.kenshine.mybatis.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 11:22
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class User {

    private Integer id;

    private String username;

    private String password;
}
