package com.kenshine.ehcache.mapper;

import com.kenshine.ehcache.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 21:48
 * @description：模拟Mapper操作
 * @modified By：
 * @version: $
 */
@Component
public class UserMapper {

    public User selectById(Integer id) {
        System.out.println("查询了数据库");
        return new User().setId(id).setUsername("kenshine").setPassword("123456");
    }

    public void updateById(User user) {
        System.out.println("更新了数据库");
        System.out.println(user);
    }

}
