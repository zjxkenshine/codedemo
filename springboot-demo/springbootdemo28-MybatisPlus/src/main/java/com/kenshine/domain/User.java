package com.kenshine.domain;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 10:19
 * @description：用户实体类
 * @modified By：
 * @version: $
 */

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true) // lombok注解，支持链式编程
@AllArgsConstructor // lombok注解，自动生成全参构造器
@NoArgsConstructor // lombok注解，自动生成无参构造器
@Data // lombok注解，自动生成get、set、toString等方法
@TableName(value = "user") // 表名注解，建立实体类与数据库表的映射关系
public class User {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO) // 主键注解，建立实体类中实例域与表中主键字段的映射关系
    private Long id;
    /**
     * 用户名
     */
    @TableField(value = "username") // 字段注解（非主键），建立实体类中实例域与表中（非主键）字段的映射关系
    private String username;
    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 用户真实姓名
     */
    @TableField(value = "realname")
    private String realname;
    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;
    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     * 用户积分
     */
    @TableField(value = "user_point")
    private Integer userPoint;
    /**
     * 用户LV
     */
    @TableField(value = "user_level")
    private Byte userLevel;
    /**
     * 出生日期
     */
    @TableField(value = "birthday")
    private LocalDateTime birthday;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;


    /**
     * 创建时间与更新时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
