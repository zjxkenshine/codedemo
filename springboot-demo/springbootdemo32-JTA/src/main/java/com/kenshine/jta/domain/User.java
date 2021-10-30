package com.kenshine.jta.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:27
 * @description：用户实体
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private Integer age;
}
