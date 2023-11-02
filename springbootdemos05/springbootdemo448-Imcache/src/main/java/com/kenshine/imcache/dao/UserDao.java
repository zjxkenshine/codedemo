package com.kenshine.imcache.dao;

import com.kenshine.imcache.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname UserDao
 * @Description 测试
 * @Date 2023-11-02 9:12
 * @modified By：
 * @version: 1.0$
 */
public class UserDao {
    static Map<String,User> map = new HashMap<>();

    static {
        map.put("1",new User(1,"kenshine1"));
        map.put("2",new User(2,"kenshine2"));
        map.put("3",new User(3,"kenshine3"));
    }

    public User get(String key) {
        System.out.println("调用了get"+key);
        return map.get(key);
    }

    public void save(String key, User user) {
        System.out.println("调用了save"+key+user);
        map.put(key,user);
    }
}
