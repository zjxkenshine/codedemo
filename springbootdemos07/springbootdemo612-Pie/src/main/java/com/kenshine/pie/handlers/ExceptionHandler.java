package com.kenshine.pie.handlers;

import com.feiniaojin.ddd.ecosystem.pie.ChannelHandlerAdapter;
import com.feiniaojin.ddd.ecosystem.pie.ChannelHandlerContext;
import com.kenshine.pie.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常处理
 * @author kenshine
 */
public class ExceptionHandler extends ChannelHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {

        logger.error("异常处理器中的异常处理逻辑");

        Result re = (Result) out;
        re.setCode(500);
        re.setMsg("系统异常");
    }
}
