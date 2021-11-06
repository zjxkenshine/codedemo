package com.kenshine.freemaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 10:52
 * @description：用户
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
