package com.kenshine.mina.test;

import com.kenshine.mina.handler.ClientHandler;
import com.kenshine.mina.socket.SocketDecoder;
import com.kenshine.mina.socket.SocketEncoder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 21:43
 * @description：测试
 * @modified By：
 * @version: $
 */
public class MinaTest {
    /**
     * 先启动MinaApplication再启动这个
     * @param args
     */
    public static void main(String[] args) {
        // 创建客户端连接器.
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        // 设置编码过滤器
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new SocketEncoder(),new SocketDecoder()));
        // 设置事件处理器
        connector.setHandler(new ClientHandler());
        // 建立连接
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1", 10010));
        // 等待连接创建完成
        cf.awaitUninterruptibly();
        // 发送消息，中英文符号都有
        cf.getSession().write("hello,kenshine}");


        // 创建客户端连接器
        NioSocketConnector connector2 = new NioSocketConnector();
        connector2.getFilterChain().addLast("logger", new LoggingFilter());
        // 设置编码过滤器
        connector2.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(StandardCharsets.UTF_8)));
        // 设置事件处理器
        connector2.setHandler(new ClientHandler());
        // 建立连接
        ConnectFuture cf2 = connector2.connect(new InetSocketAddress("127.0.0.1", 10011));
        // 等待连接创建完成
        cf2.awaitUninterruptibly();
        // 发送消息，中英文都有
        cf2.getSession().write("test,kenshine,port2");
    }
}
