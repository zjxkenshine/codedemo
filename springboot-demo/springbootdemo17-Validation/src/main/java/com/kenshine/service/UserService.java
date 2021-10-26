package com.kenshine.service;

import com.kenshine.domain.User;
import com.kenshine.response.CommonResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 14:56
 * @description：用户业务接口
 * @modified By：
 * @version: $
 *
 * @Validated 和 @Valid注解组合可以校验任何组件
 */
@Validated
public interface UserService {
    /**
     * 更新用户
     *
     * @param user 用户参数
     * @return CommonResult<User>
     */
    CommonResult<User> updateUser(@Valid User user);

}
