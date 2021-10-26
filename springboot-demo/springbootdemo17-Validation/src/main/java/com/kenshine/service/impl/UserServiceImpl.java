package com.kenshine.service.impl;

import com.kenshine.domain.User;
import com.kenshine.response.CommonResult;
import com.kenshine.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 14:56
 * @description：用户实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public CommonResult<User> updateUser(User user) {
        return CommonResult.ok("更新用户成功", user);
    }

}
