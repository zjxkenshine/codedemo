package com.kenshine.pagehelper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenshine.pagehelper.domain.User;
import com.kenshine.pagehelper.mapper.UserMapper;
import com.kenshine.pagehelper.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 9:43
 * @description：用户接口实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
