package com.kenshine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 8:28
 * @description：用户实体类
 * @modified By：
 * @version: $
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
