package com.kenshine.domain;

import com.kenshine.annotation.Password;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 15:22
 * @description：金额
 * @modified By：
 * @version: $
 */
@Data
public class Account {

    @NotNull(message = "账户id不能为空")
    private Long accountId;

    @Size(min = 6, max = 20, message = "账户名长度不小于6，不超过20")
    @NotNull(message = "账户名不能为空")
    private String accountName;

    @Password(message = "密码必须以大写英文字母开头，只包含英文字母、数字、下划线，长度在6到20之间")
    @NotNull(message = "账户密码不能为空")
    private String accountPassword;

}
