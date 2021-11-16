package com.kenshine.dynamic.entity;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 10:37
 * @description：db1实体类user
 * @modified By：
 * @version: $
 */
@Data
@TableName(value = "user")
@DS("master")
public class User {
    private Integer id;
    private String username;
    private Integer age;
}
