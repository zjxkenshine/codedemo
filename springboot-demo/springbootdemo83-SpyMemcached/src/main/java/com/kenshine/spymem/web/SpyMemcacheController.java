package com.kenshine.spymem.web;

import com.kenshine.spymem.config.SpyMemcacheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/14 20:44
 * @description：测试Controller
 * @modified By：
 * @version: $
 */
@RestController
public class SpyMemcacheController {

    @Autowired
    private SpyMemcacheConfig spyMemcacheConfig;

    @RequestMapping("/spyMemcacheIndex")
    public String spyMemcacheIndex() throws InterruptedException {
        /*这个过期时间单位是秒，最大值是60*60*24*30*/
        spyMemcacheConfig.getClient().set("spyMemcachedKey",1,"张三");
        System.out.println("基于spyMemcached实现，现在的值为 "+spyMemcacheConfig.getClient().get("spyMemcachedKey"));
        Thread.sleep(2000);
        System.out.println("1秒后缓存内容清除，现在的值为： "+spyMemcacheConfig.getClient().get("spyMemcachedKey"));
        return "aaaaa";
    }

}
