package com.kenshine.coherence.cache.service.impl;


import com.kenshine.coherence.cache.domain.UserInfo;
import com.kenshine.coherence.cache.mapper.UserInfoMapper;
import com.kenshine.coherence.cache.service.UserInfoService;
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
    @CachePut(value= "user", key = "#userInfo.id")
    public UserInfo addUserInfo(UserInfo userInfo) {
        log.info("create");
        return userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    @Cacheable(value= "user",key = "#id")
    public UserInfo getByName(Integer id) {
        return userInfoMapper.getByName(id);
    }

    @Override
    @CachePut(value= "user",key = "#userInfo.id")
    public UserInfo updateUserInfo(UserInfo userInfo) {
        log.info("update");
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    @CacheEvict(value= "user", key = "#id")
    public void deleteById(Integer id) {
        log.info("delete");
        userInfoMapper.deleteById(id);
    }
}
