package com.kenshine.mina.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 21:34
 * @description：客户端处理器
 * @modified By：
 * @version: $
 */
@Slf4j
public class ClientHandler extends IoHandlerAdapter {

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String address = session.getRemoteAddress().toString();
        log.warn("客户端收到["+address+"]消息：" + message);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }
}
