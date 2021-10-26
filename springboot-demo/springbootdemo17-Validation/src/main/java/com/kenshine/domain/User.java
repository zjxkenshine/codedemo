package com.kenshine.domain;

import com.kenshine.annotation.Password;
import com.kenshine.annotation.Rank;
import com.kenshine.groups.AddUserGroup;
import com.kenshine.groups.ModifyUserGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 14:13
 * @description：用户实体类
 * @modified By：
 * @version: $
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @NotNull(message = "id不能为空")
    private Long id;

    @Length(min = 6, max = 20, message = "用户名长度不小于6，不超过20")
    @NotNull(message = "用户名不能为空")
    //不写groups为默认分组
    @NotNull(message = "id不能为空", groups = ModifyUserGroup.class)
    @Null(message = "id必须为空", groups = AddUserGroup.class)
    private String username;

    //@Pattern(regexp = "^[A-Z][A-Za-z0-9_]{5,19}$", message = "密码以大写英文字母开头，只包含英文字母、数字、下划线，长度在6到20之间")
    //自定义password注解
    @Password(message = "密码必须以大写英文字母开头，只包含英文字母、数字、下划线，长度在6到20之间")
    @NotNull(message = "密码不能为空")
    private String password;

    @Max(value = 60, message = "年龄最大为60")
    @Min(value = 18, message = "年龄最小为18")
    @NotNull(message = "年龄不能为空")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    //自定义Rank注解
    @Rank(message = "段位必须为无段位、青铜、白银、黄金、铂金、钻石之一")
    private String rank;

}
