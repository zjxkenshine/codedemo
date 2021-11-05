package com.kenshine.ehcache.service;

import com.kenshine.ehcache.domain.User;
import com.kenshine.ehcache.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 21:47
 * @description：缓存
 * @modified By：
 * @version: $
 */
@Service
@Slf4j
public class CacheService {

    @Resource
    private UserMapper userMapper ;

    /**
     *  在缓存有效期内，首次查询才访问数据库
     */
    @Cacheable(value="user")
    public User getById (Integer id){
        // 通过日志，标识方法是否执行
        log.info("getById..."+id);
        return userMapper.selectById(id) ;
    }

    /**
     *  该ID数据更新，清空该ID缓存
     */
    @CacheEvict(value="user",key = "#id")
    public void updateUser(Integer id) {
        User user = new User() ;
        user.setId(id);
        user.setUsername("kenshine");
        userMapper.updateById(user);
    }

}
