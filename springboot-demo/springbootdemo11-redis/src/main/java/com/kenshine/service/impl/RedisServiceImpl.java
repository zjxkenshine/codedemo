package com.kenshine.service.impl;

import com.kenshine.service.RedisService;
import com.kenshine.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 14:25
 * @description：redis业务实现
 * @modified By：
 * @version: $
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void setObj(String key, Object obj, long timeout) {
        redisUtil.set(key,obj,timeout);
    }

    @Override
    public Object getObj(String key) {
        return redisUtil.get(key);
    }
    
}
