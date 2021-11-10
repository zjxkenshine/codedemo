package com.kenshine.mina.config;

import com.kenshine.mina.handler.ServerHandler;
import com.kenshine.mina.socket.SocketFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.Charset;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 21:25
 * @description：Mina配置
 * @modified By：
 * @version: $
 */
@Slf4j
@Configuration
public class MinaConfig {

    /**服务器端口1*/
    @Value("${mina.port1}")
    private int port1;

    /**服务器端口二*/
    @Value("${mina.port2}")
    private int port2;

    @Value("${mina.host}")
    private String host;

    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }

    @Bean
    public IoHandler ioHandler() {
        return new ServerHandler();
    }

    @Bean
    public IoAcceptor ioAcceptor() throws Exception {
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", loggingFilter());
        // 使用自定义编码解码工厂类
        acceptor.getFilterChain().addLast("coderc", new ProtocolCodecFilter(new SocketFactory(Charset.forName("utf-8"))));
        acceptor.setHandler(ioHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        SocketAddress addresses = new InetSocketAddress(host,port1);
        SocketAddress addresses2 = new InetSocketAddress(host,port2);
        acceptor.bind(new SocketAddress[] {addresses,addresses2});
        log.info("=====================> Mina服务器在端口：" + port1+","+port2 + "已经启动!");
        return acceptor;
    }

}
