package com.kenshine.dbunit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 8:50
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String pwd;
}
