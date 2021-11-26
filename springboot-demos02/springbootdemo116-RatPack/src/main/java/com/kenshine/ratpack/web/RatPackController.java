package com.kenshine.ratpack.web;

import com.kenshine.ratpack.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import ratpack.error.ServerErrorHandler;
import ratpack.func.Action;
import ratpack.handling.Chain;

import java.util.Collections;

import static ratpack.jackson.Jackson.json;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 10:02
 * @description：RatPack配置
 * @modified By：
 * @version: $
 *
 * RatpackServer
 */
@Controller
public class RatPackController {

    @Autowired
    private MessageService service;

    /**
     *  Handler只是一个用于处理上下文 Context的一个函数
     *  相当于Controller
     * @return
     */
    @Bean
    public Action<Chain> handler() {
        return chain -> chain.get(context -> {
            //context.getRequest();
            context.render(json(Collections.singletonMap("message", service.message())));
        });
    }

    /**
     * 错误处理
     * @return
     */
    @Bean
    public ServerErrorHandler serverErrorHandler() {
        return (context, error) -> context.getResponse().status(200).send(error.getMessage());
    }

}
