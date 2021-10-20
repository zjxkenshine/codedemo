package com.kenshine.jdbc.dao;

import com.kenshine.jdbc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 10:22
 * @description：dao层接口
 * @modified By：
 * @version: $
 *
 */
public interface IUserDao {

    int add(User student);

    int update(User student);

    int delete(int id);

    User findUserById(int id);

    List<User> findUserList();

}
