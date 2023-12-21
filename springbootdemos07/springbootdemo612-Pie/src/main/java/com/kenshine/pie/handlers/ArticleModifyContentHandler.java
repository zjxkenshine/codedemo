package com.kenshine.pie.handlers;

import com.feiniaojin.ddd.ecosystem.pie.ChannelHandler;
import com.feiniaojin.ddd.ecosystem.pie.ChannelHandlerContext;
import com.kenshine.pie.ArticleTitleModifyCmd;
import com.kenshine.pie.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kenshine
 * 修改内容handler
 */
public class ArticleModifyContentHandler implements ChannelHandler {

    private Logger logger = LoggerFactory.getLogger(ArticleModifyContentHandler.class);

    @Override
    public void channelProcess(ChannelHandlerContext ctx,
                               Object in,
                               Object out) throws Exception {

        logger.info("修改正文:进入修改正文的Handler");
        ArticleTitleModifyCmd cmd = (ArticleTitleModifyCmd) in;
        logger.info("修改正文,content={}", cmd.getContent());
        logger.info("修改正文:执行完成,即将进入下一个Handler");
        ctx.fireChannelProcess(in, out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {

        logger.error("修改标题:异常处理逻辑");

        Result re = (Result) out;
        re.setCode(1502);
        re.setMsg("修改正文发生异常");
    }
}
