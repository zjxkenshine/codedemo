package com.kenshine.service.impl;

import com.kenshine.dao.dao02.UserRepository;
import com.kenshine.entity.User;
import com.kenshine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:25
 * @description：用户业务接口实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
