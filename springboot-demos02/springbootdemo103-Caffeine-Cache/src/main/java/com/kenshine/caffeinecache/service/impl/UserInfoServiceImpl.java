package com.kenshine.caffeinecache.service.impl;

import com.kenshine.caffeinecache.domain.UserInfo;
import com.kenshine.caffeinecache.mapper.UserInfoMapper;
import com.kenshine.caffeinecache.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/20 8:39
 * @description：用户信息接口实现
 * @modified By：
 * @version: $
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    @CachePut(value="userInfo", key = "#userInfo.id")
    public UserInfo addUserInfo(UserInfo userInfo) {
        log.info("create");
        return userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    @Cacheable(value="userInfo",key = "#id")
    public UserInfo getByName(Integer id) {
        return userInfoMapper.getByName(id);
    }

    @Override
    @CachePut(value="userInfo",key = "#userInfo.id")
    public UserInfo updateUserInfo(UserInfo userInfo) {
        log.info("update");
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    @CacheEvict(value="userInfo", key = "#id")
    public void deleteById(Integer id) {
        log.info("delete");
        userInfoMapper.deleteById(id);
    }
}
