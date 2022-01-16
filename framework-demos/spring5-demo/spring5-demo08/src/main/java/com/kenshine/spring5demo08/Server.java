package com.kenshine.spring5demo08;

import com.kenshine.spring5demo08.handler.UserHandler;
import com.kenshine.spring5demo08.service.UserService;
import com.kenshine.spring5demo08.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;


/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 22:25
 * @description：
 * @modified By：
 * @version: $
 */
public class Server {
    //1.创建Router路由
    public RouterFunction<ServerResponse> routingFunction(){
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        // 前一个参数判断是否是路径   后一个参数调用处理对应处理方法
        return RouterFunctions.route(
                RequestPredicates.GET("/user/{id}").and(RequestPredicates.accept(APPLICATION_JSON))
                ,handler::setUserById
        ).andRoute(
                RequestPredicates.GET("/users").and(RequestPredicates.accept(APPLICATION_JSON))
                ,handler::getAllUser
        );
    }

    //2.创建服务器完成适配
    public void createReactorServer(){
        //路由和Handler适配
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);
        //创建适配器
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器
        HttpServer httpServer = HttpServer.create().port(8080);
        //完成适配
        httpServer.handle(adapter).bindNow();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit!");
        System.in.read();
    }


}
