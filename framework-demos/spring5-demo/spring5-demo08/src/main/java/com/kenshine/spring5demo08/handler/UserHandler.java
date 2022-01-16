package com.kenshine.spring5demo08.handler;

import com.kenshine.spring5demo08.entity.User;
import com.kenshine.spring5demo08.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 22:08
 * @description：
 * @modified By：
 * @version: $
 */
public class UserHandler {

    private final UserService userService;
    public UserHandler(UserService userService){
        this.userService = userService;
    }

    //根据id查询
    public Mono<ServerResponse> setUserById(ServerRequest request){
        //获取path参数 id
        int userId = Integer.valueOf(request.pathVariable("id"));
        //获取数据
        Mono<User> userMono = this.userService.getUserById(userId);
        //把userMono进行转换返回
        //使用flatMap
       return userMono
               .flatMap(person ->
                        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person))
               );
    }

    //查询所有
    public Mono<ServerResponse> getAllUser(ServerRequest serverRequest){
        //调用Service得到结果
        Flux<User> userFlux = this.userService.getAllUser();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userFlux,User.class);
    }

    //添加
    public Mono<ServerResponse> saveUser(ServerRequest request){
        //得到User对象
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }

}











