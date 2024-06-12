package com.kenshine.socketd.test02;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.EventListener;
import org.noear.socketd.transport.core.listener.PipelineListener;

/**
 * @author by kenshine
 * @Classname PipelineListenerDemo
 * @Description 管道监听器
 * @Date 2024-06-12 8:42
 * @modified By：
 * @version: 1.0$
 */
public class PipelineListenerDemo {
    public static void main(String[] args) throws Throwable {
        //::启动服务端
        SocketD.createServer("sd:udp")
                .config(c -> c.port(8602))
                .listen(new PipelineListener().next(new EventListener().doOnMessage((s, m) -> {
                    //这里可以做拦截
                    System.out.println("拦截打印::" + m);
                })).next(new EventListener().doOnMessage((s, m) -> {
                    //这里可以做业务处理
                    System.out.println(m);
                })))
                .start();

        //等会儿，确保服务端启动完成
        Thread.sleep(1000);

        //::打开客户端会话
        ClientSession clientSession = SocketD.createClient("sd:udp://127.0.0.1:8602/hello?u=a&p=2")
                .open();
        clientSession.send("/demo", new StringEntity("Hi"));
    }
}
