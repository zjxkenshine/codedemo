package com.kenshine.socketio;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 11:01
 * @description：SocketIO实现消息推送
 * @modified By：
 * @version: $
 *
 * TODO Socketio 聊天室实现
 */
@SpringBootApplication
@RestController
public class SocketIOApp implements CommandLineRunner {

    @Autowired
    private SocketIOServer socketIOServer;

    public static void main(String[] args) {
        SpringApplication.run(SocketIOApp.class, args);
    }


    public void run(String... args) throws Exception {
        socketIOServer.start();//启动
    }


}
