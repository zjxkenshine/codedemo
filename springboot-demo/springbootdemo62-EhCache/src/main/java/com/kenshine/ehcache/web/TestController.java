package com.kenshine.ehcache.web;

import com.kenshine.ehcache.domain.User;
import com.kenshine.ehcache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 22:00
 * @description：Ehcache测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class TestController {
    @Autowired
    private CacheService cacheService;

    @GetMapping("/getUser")
    public User getUser(){
        return cacheService.getById(1);
    }

    @GetMapping("/update")
    public void updateUser(){
        cacheService.updateUser(1);
    }


}
