package com.kenshine.netty.server;

import com.alibaba.fastjson.JSON;
import com.kenshine.netty.channel.NettyChannelMap;
import com.kenshine.netty.pojo.ChatDto;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kenshine
 * Netty服务处理
 */
@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {


    /**
     * 定义一个channel组管理所有channel
     * GlobalEventExecutor.INSTANCE 是一个全局事件执行器 是一个单例
     */
    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 标识 channel处于活动状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 表示连接建立 第一个被执行
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());

        /**
         *  该方法会将 channelGroup 中所有的channel 遍历一遍然后发送消息 不用我们自己遍历
         *   这里只是做个说明 不用
         */
      //  channelGroup.writeAndFlush("发送所有给所有channel");
    }

    /**
     * 断开连接
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 标识channel处于非活动状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyChannelMap.remove((SocketChannel) ctx.channel());
    }


    /**
     * 服务端 接收到 客户端 发的数据
     * @param context
     * @param obj
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext context, Object obj) throws Exception {

        log.info(">>>>>>>>>>>服务端接收到客户端的消息：{}",obj);

        SocketChannel socketChannel = (SocketChannel) context.channel();
        ChatDto dto = JSON.parseObject(obj.toString(), ChatDto.class);
        /**
         * 客户端ID
         */
        String clientId = dto.getClientId();

        if (clientId == null) {
            /**
             * 心跳包处理
             */
            ChatDto pingDto=new ChatDto();
            pingDto.setMsg("服务端收到心跳包，返回响应");
            socketChannel.writeAndFlush(JSON.toJSONString(pingDto));
            return;
        }

        Channel channel = NettyChannelMap.get(clientId);

        if (channel==null){
            /**
             * 存放所有连接客户端
             */
            NettyChannelMap.add(clientId, socketChannel);
            channel=socketChannel;
        }


        /**
         * 服务器返回客户端消息
         */
        ChatDto returnDto=new ChatDto();
        returnDto.setClientId(clientId).setMsg("我是服务端，收到你的消息了");

        channel.writeAndFlush(JSON.toJSONString(returnDto));


        /**
         * 在这里可以设置异步执行 提交任务到该channel的taskQueue 中
         */

        context.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(10*1000);
                log.info(">>>>>>>>>休眠十秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /**
         * 可以设置多个异步任务
         * 但是这个会在上面异步任务执行完之后才执行
         */
        context.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(10*1000);
                log.info(">>>>>>>>>休眠二十秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        ReferenceCountUtil.release(obj);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}