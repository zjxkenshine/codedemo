package com.kenshine.netty.controller;

import com.alibaba.fastjson.JSON;
import com.kenshine.netty.client.NettyClientBootstrap;
import com.kenshine.netty.pojo.ChatDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * @author kenshine
 *
 */
@RestController
@Slf4j
public class ChatController {
    private static String clientId= UUID.randomUUID().toString();
    public static NettyClientBootstrap bootstrap;

    /**
     * 发送消息
     * localhost:8080/send
     */
    @PostMapping(value = "/send")
    public void send(String msg) {
        if (bootstrap == null) {
            try {
                /**
                 * 连接 输入服务器的端口和ip
                 */
                bootstrap = new NettyClientBootstrap(9999, "localhost");
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error(">>>>>>>>> server socket 连接失败");
            }
        }
        /**
         *   发送消息
         */
        ChatDto dto=new ChatDto();
        dto.setClientId(clientId).setMsg(msg);
        /**
         * json字符串发送
         */
        bootstrap.socketChannel.writeAndFlush(JSON.toJSONString(dto));
    }
}