package com.kenshine.ratelimit.service;

import com.github.houbb.rate.limit.core.annotation.RateLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author by kenshine
 * @Classname UserService
 * @Description 用户测试
 * @Date 2023-11-08 8:21
 * @modified By：
 * @version: 1.0$
 */
@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    /**
     * 2秒5次
     */
    @RateLimit(interval = 2, count = 5)
    public String limitCount() {
        return "kenshine";
    }

}
