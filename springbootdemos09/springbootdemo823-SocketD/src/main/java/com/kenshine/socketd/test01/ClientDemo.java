package com.kenshine.socketd.test01;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.entity.StringEntity;

/**
 * @author kenshine
 * 客户端
 */
public class ClientDemo {
    public static void main(String[] args) throws Throwable {
        //::打开客户端会话
        ClientSession session = SocketD.createClient("sd:tcp://127.0.0.1:8602/?token=1b0VsGusEkddgr3d")
                .open();


        Entity entity = new StringEntity("Hello wrold!").metaPut("user","kenshine");
        
        //发送
        session.send("/demo", entity);
        //发送并请求（且，等待答复）
        Entity reply = session.sendAndRequest("/demo", entity).await();
        //发送并订阅（且，接收答复流）
        session.sendAndSubscribe("/demo", entity).thenReply(reply1->{
            
        });
    }
}