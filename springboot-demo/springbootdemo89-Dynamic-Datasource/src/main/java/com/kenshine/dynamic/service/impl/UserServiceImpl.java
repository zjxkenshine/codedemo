package com.kenshine.dynamic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenshine.dynamic.entity.User;
import com.kenshine.dynamic.mapper.UserMapper;
import com.kenshine.dynamic.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 10:55
 * @description：用户业务实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
