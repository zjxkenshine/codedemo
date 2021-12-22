package com.kenshine.pagehelper.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 9:21
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@TableName("user")
public class User extends BasePage{

    @TableId(value = "id",type = IdType.AUTO)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /**
     * 姓名
     */
    private String name;
}
