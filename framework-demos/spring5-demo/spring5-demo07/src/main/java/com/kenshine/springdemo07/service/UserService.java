package com.kenshine.springdemo07.service;

import com.kenshine.springdemo07.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 21:33
 * @description：用户操作接口
 * @modified By：
 * @version: $
 */
public interface UserService {
    //根据id查询用户
    Mono<User> getUserById(int id);//Mono返回单个或零个元素

    //查询所有用户
    Flux<User> getAllUser();//Flux返回多个元素

    //添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
