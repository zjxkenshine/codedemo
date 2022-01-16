package com.kenshine.spring5demo08.service.impl;

import com.kenshine.spring5demo08.entity.User;
import com.kenshine.spring5demo08.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 21:52
 * @description：
 * @modified By：
 * @version: $
 */
@Repository
public class UserServiceImpl implements UserService {
    //创建map集合存储数据
    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1,new User("kenshine","nan",20));
        this.users.put(2,new User("qin","nv",30));
        this.users.put(3,new User("bin","nan",50));
    }

    //根据id查询
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    //查询多个用户
    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    //添加用户
    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            //向map集合里面放值
            int id = users.size()+1;
            users.put(id,person);
        }).thenEmpty(Mono.empty()); //thenEmpty终止操作
    }

}
