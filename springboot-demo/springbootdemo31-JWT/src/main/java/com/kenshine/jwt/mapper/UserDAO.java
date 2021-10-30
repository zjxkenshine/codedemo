package com.kenshine.jwt.mapper;

import com.kenshine.jwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 9:02
 * @description：用户dao
 * @modified By：
 * @version: $
 */
@Mapper
public interface UserDAO {
    //根据用户名密码登录
    User login(User user);
}
