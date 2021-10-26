package com.kenshine.service;

import com.kenshine.domain.User;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 8:48
 * @description：用户Service
 * @modified By：
 * @version: $
 */
public interface UserService {
    User findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
