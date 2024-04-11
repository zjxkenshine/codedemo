package com.kenshine.netty.client;

import com.alibaba.fastjson.JSON;
import com.kenshine.netty.pojo.ChatDto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kenshine
 * 客户端处理
 */
@Slf4j
public class NettyClientHandler extends SimpleChannelInboundHandler<Object> {


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info(">>>>>>>>连接");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info(">>>>>>>>退出");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    /**
                     *  利用写空闲发送心跳检测消息
                     */
                    ChatDto pingDto=new ChatDto();
                    pingDto.setMsg("我是心跳包");
                    ctx.writeAndFlush(JSON.toJSONString(pingDto));
                    log.info("send ping to server----------");
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * 客户端接收到服务端发的数据
     * @param channelHandlerContext
     * @param obj
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object obj)  {

        log.info(">>>>>>>>>>>>>客户端接收到消息：{}", obj);


        ReferenceCountUtil.release(obj);
    }


    /**
     * socket通道处于活动状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info(">>>>>>>>>>socket建立了");
        super.channelActive(ctx);
    }


    /**
     * socket通道不活动了
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info(">>>>>>>>>>socket关闭了");
        super.channelInactive(ctx);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}