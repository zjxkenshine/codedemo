package com.kenshine.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 9:13
 * @description：用户类
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class User {
    private Long Id;
    private String username;
    private String password;
}
