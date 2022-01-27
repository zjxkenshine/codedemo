package com.kenshine.chat.server.handler;

import com.kenshine.chat.message.GroupMembersRequestMessage;
import com.kenshine.chat.message.GroupMembersResponseMessage;
import com.kenshine.chat.server.session.GroupSessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/27 14:56
 * @description：
 * @modified By：
 * @version: $
 * 查看群成员
 */
@ChannelHandler.Sharable
public class GroupMembersMessageHandler extends SimpleChannelInboundHandler<GroupMembersRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMembersRequestMessage msg) throws Exception {
        ctx.writeAndFlush(new GroupMembersResponseMessage(GroupSessionFactory.getGroupSession().getMembers(msg.getGroupName())));
    }
}
