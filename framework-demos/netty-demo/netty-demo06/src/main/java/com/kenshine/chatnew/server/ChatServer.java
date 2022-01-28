package com.kenshine.chatnew.server;


import com.kenshine.chatnew.protocol.MessageCodecSharable;
import com.kenshine.chatnew.protocol.ProcotolFrameDecoder;
import com.kenshine.chatnew.server.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatServer {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
        // 登录处理器
        LoginRequestMessageHandler loginRequestMessageHandler = new LoginRequestMessageHandler();
        // 单聊处理器
        final ChatRequestMessageHandler chatRequestMessageHandler  = new ChatRequestMessageHandler();
        // 创建群聊
        GroupCreateRequestMessageHandler groupCreateMessageHandler = new GroupCreateRequestMessageHandler();
        // 处理群聊聊天
        GroupChatRequestMessageHandler groupChatMessageHandler = new GroupChatRequestMessageHandler();
        // 处理加入群聊
        GroupJoinMessageHandler groupJoinMessageHandler = new GroupJoinMessageHandler();
        // 处理退出群聊
        GroupQuitMessageHandler groupQuitMessageHandler = new GroupQuitMessageHandler();
        // 处理查看群成员
        GroupMembersMessageHandler groupMembersMessageHandler = new GroupMembersMessageHandler();
        // 退出
        QuitHandler quitHandler = new QuitHandler();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.group(boss, worker);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    //编解码器
                    ch.pipeline().addLast(new ProcotolFrameDecoder());
                    ch.pipeline().addLast(LOGGING_HANDLER);
                    ch.pipeline().addLast(MESSAGE_CODEC);

                    //连接假死处理 5s内未读到数据，会触发READ_IDLE事件
                    ch.pipeline().addLast(new IdleStateHandler(5, 0, 0));
                    // 添加双向处理器，负责处理READER_IDLE事件
                    ch.pipeline().addLast(new ChannelDuplexHandler() {
                        @Override
                        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                            // 获得事件
                            IdleStateEvent event = (IdleStateEvent) evt;
                            // 判断是否读事件 相等则触发读空闲事件
                            if (event.state() == IdleState.READER_IDLE) {
                                log.debug("已经5S没有读到数据了,连接断开");
                                // 断开连接
                                ctx.channel().close();
                            }
                        }
                    });



                    ch.pipeline().addLast(loginRequestMessageHandler); //添加入站处理器 处理登录消息
                    ch.pipeline().addLast(chatRequestMessageHandler);  //单聊处理器
                    ch.pipeline().addLast(groupCreateMessageHandler);  //创建群处理器
                    ch.pipeline().addLast(groupChatMessageHandler);  //群聊处理
                    ch.pipeline().addLast(groupJoinMessageHandler);  //加群处理
                    ch.pipeline().addLast(groupQuitMessageHandler);   //退群处理
                    ch.pipeline().addLast(groupMembersMessageHandler);  //查看群成员
                    ch.pipeline().addLast(quitHandler);  //退出群聊
                }
            });
            Channel channel = serverBootstrap.bind(8080).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("server error", e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

}
