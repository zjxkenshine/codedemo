package com.kenshine.service;

import com.kenshine.domain.User;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 18:03
 * @description：用户Service
 * @modified By：
 * @version: $
 */
public interface UserService {

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);

}
