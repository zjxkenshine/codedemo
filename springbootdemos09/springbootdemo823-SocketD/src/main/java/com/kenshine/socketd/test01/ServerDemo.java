package com.kenshine.socketd.test01;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.listener.SimpleListener;

import java.io.IOException;

/**
 * @author kenshine
 * 服务端
 */
public class ServerDemo {
    public static void main(String[] args) throws Throwable {
        //::启动服务端
        SocketD.createServer("sd:tcp")
                .config(c -> c.port(8602))
                .listen(new SimpleListener(){
                    @Override
                    public void onMessage(Session session, Message message) throws IOException {
                        //打印
                        System.out.println(message);
                    }
                })
                .start();
    }
}