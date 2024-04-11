package com.kenshine.netty;

import com.kenshine.netty.server.NettyTcpServerBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by kenshine
 * @Classname NettyApplication
 * @Description Netty启动类
 * @Date 2024-04-11 8:15
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
public class NettyApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);

        // 启动netty服务
        try {
            NettyTcpServerBootstrap bootstrap = new NettyTcpServerBootstrap(9999);
            bootstrap.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("server socket 启动失败");
        }
    }
}
