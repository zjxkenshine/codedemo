package com.kenshine.jdbc.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 10:17
 * @description：用户1实体
 * @modified By：
 * @version: 1.0$
 */
@Data
@ToString
public class User {

    private Integer id;

    private String username;

    private String password;

}
