package com.kenshine.easyexcel.service.impl;

import com.kenshine.easyexcel.domain.User;
import com.kenshine.easyexcel.mapper.UserMapper;
import com.kenshine.easyexcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 16:39
 * @description：用户业务接口实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void saveBatch(List<User> list) {
        userMapper.saveBatch(list);
    }
}
