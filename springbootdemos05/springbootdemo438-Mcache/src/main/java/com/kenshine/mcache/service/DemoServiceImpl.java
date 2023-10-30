package com.kenshine.mcache.service;

import com.kenshine.mcache.model.User;
import com.msimw.mcache.annotation.CacheEvict;
import com.msimw.mcache.annotation.Cacheable;
import com.msimw.mcache.annotation.Cached;
import org.springframework.stereotype.Service;

/**
 * @author by kenshine
 * @Classname DemoServiceImpl
 * @Description 测试
 * @Date 2023-10-30 8:53
 * @modified By：
 * @version: 1.0$
 */
@Service
@Cached
public class DemoServiceImpl {
    /**
     * 缓存
     */
    @Cacheable(keys = "id")
    public String query(String id, String name) {
        return "helloworld";
    }

    /**
     * 更新
     */
    @CacheEvict(keys = "id")
    public void update(String id, String name) {
        System.out.println("修改成功");
    }

    /**
     * 查询
     */
    @Cacheable(keys = "id")
    public String query1(String id) {
        return "helloworld";
    }

    /**
     * 更新
     */
    @CacheEvict(keys = "id")//or  @CacheEvict(keys = "demo.id")
    public void update1(User user) {
    }

}
