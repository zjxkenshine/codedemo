package com.kenshine.p6spy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/7 23:09
 * @description：用户实体类
 * @modified By：
 * @version: $
 */
@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;
}
