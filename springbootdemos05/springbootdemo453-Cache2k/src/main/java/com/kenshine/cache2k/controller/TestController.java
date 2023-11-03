package com.kenshine.cache2k.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description controller
 * @Date 2023-11-03 12:54
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/test01")
    public void test01(){
        Cache cache=cacheManager.getCache("cache2k");
        cache.put(1,"kenshine");
    }

    @GetMapping("/test02")
    public void test02(){
        Cache cache=cacheManager.getCache("cache2k");
        String s=cache.get(1,String.class);
        System.out.println(s);
    }
}
