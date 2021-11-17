package com.kenshine.equator.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 10:10
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
    private String password;
}
