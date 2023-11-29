package com.kenshine.validator.model;

import com.github.houbb.validator.api.constant.enums.FailTypeEnum;
import com.github.houbb.validator.core.annotation.constraint.AllEquals;
import com.github.houbb.validator.core.annotation.constraint.EnumRanges;
import com.github.houbb.validator.core.annotation.constraint.HasNotNull;
import com.github.houbb.validator.core.annotation.constraint.Ranges;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author by kenshine
 * @Classname User
 * @Description 用户
 * @Date 2023-11-29 8:15
 * @modified By：
 * @version: 1.0$
 */
@Data
@Accessors(chain = true)
public class User {

    /**
     * 名称
     */
    @HasNotNull({"nickName"})
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 原始密码
     */
    @AllEquals("password2")
    private String password;

    /**
     * 新密码
     */
    private String password2;

    /**
     * 性别
     */
    @Ranges({"boy", "girl"})
    private String sex;

    /**
     * 失败类型枚举
     */
    @EnumRanges(FailTypeEnum.class)
    private String failType;
}
