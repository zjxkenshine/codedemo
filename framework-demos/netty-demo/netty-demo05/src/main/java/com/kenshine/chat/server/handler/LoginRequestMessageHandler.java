package com.kenshine.chat.server.handler;

import com.kenshine.chat.message.LoginRequestMessage;
import com.kenshine.chat.message.LoginResponseMessage;
import com.kenshine.chat.server.service.UserServiceFactory;
import com.kenshine.chat.server.session.SessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/27 13:03
 * @description：
 * @modified By：
 * @version: $
 *
 * 注意要加Sharable，否则多个Client不会复用
 */
@ChannelHandler.Sharable
public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        String username = msg.getUsername();
        String password = msg.getPassword();
        boolean login = UserServiceFactory.getUserService().login(username, password);
        LoginResponseMessage message;
        if (login) {
            SessionFactory.getSession().bind(ctx.channel(), username);
            //响应消息
            message = new LoginResponseMessage(true, "登录成功");
        } else {
            message = new LoginResponseMessage(false, "用户名或密码不正确");
        }
        ctx.writeAndFlush(message);
    }
}
