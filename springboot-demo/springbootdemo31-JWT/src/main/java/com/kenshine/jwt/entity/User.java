package com.kenshine.jwt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 9:01
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain=true)
public class User {
    private String id;
    private String name;
    private String password;
}
