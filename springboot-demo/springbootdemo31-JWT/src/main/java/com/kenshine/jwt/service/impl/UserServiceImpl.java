package com.kenshine.jwt.service.impl;

import com.kenshine.jwt.entity.User;
import com.kenshine.jwt.mapper.UserDAO;
import com.kenshine.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 9:07
 * @description：用户接口实现
 * @modified By：
 * @version: $
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDB = userDAO.login(user);
        if(userDB!=null){
            return userDB;
        }
        throw  new RuntimeException("登录失败~~");
    }

}
