package com.kenshine.lock4j.service;

import com.baomidou.lock.annotation.Lock4j;
import com.kenshine.lock4j.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author by kenshine
 * @Classname XlService
 * @Description 限流测试
 * @Date 2023-08-03 19:47
 * @modified By：
 * @version: 1.0$
 */
@Service
public class XlService {
    // 用户在5秒内只能访问1次
    @Lock4j(keys = {"#user.id"}, acquireTimeout = 0, expire = 5000, autoRelease = false)
    public Boolean test(User user) {
        System.out.println(user);
        return true;
    }

}
