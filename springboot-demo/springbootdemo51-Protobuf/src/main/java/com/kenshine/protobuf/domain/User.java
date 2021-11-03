package com.kenshine.protobuf.domain;

import io.protostuff.Tag;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 17:44
 * @description：用户
 * @modified By：
 * @version: $
 *
 * //@Tag 配置字段编号，Tag一般也可以看做Key
 */
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // 用户ID
    @Tag(1)
    private int userId;

    // 用户类型
    @Tag(2)
    private int userTypeId;

    // 用户名
    @Tag(3)
    private String userName;

    // 创建时间
    @Tag(4)
    private Date createDateTime;

}
