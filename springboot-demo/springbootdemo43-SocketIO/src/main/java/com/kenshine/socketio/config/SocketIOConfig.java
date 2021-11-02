package com.kenshine.socketio.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 11:08
 * @description：SocketIO配置
 * @modified By：
 * @version: $
 *
 * 两个bean
 * SocketIOServer
 * SpringAnnotationScanner
 */
@Configuration
public class SocketIOConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setTcpNoDelay(true);
        socketConfig.setSoLinger(0);
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setSocketConfig(socketConfig);
        config.setHostname("localhost");
        //socket端口
        config.setPort(8091);
        config.setBossThreads(100);
        config.setWorkerThreads(100);
        config.setAllowCustomRequests(true);
        config.setUpgradeTimeout(1000000);
        config.setPingTimeout(6000000);
        config.setPingInterval(25000);
        return new SocketIOServer(config);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner() {
        return new SpringAnnotationScanner(socketIOServer());
    }
}
