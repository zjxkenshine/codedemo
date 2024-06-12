package com.kenshine.socketd.test03;

import org.noear.socketd.SocketD;
import org.noear.socketd.broker.BrokerFragmentHandler;
import org.noear.socketd.broker.BrokerListener;
import org.noear.socketd.transport.core.Session;

import java.io.IOException;

/**
 * @author 自定义Broker监听器
 */ //做了一个简单的鉴权处理
public class BrokerListenerEx extends BrokerListener {
    @Override
    public void onOpen(Session session) throws IOException {
        if("demo".equals(session.param("token")) == false){
            session.close();
            return;
        }
        
        //注意父类事件要保留
        super.onOpen(session);
    }
}

//启动时，使用新的监听器
class Demo {
    public static void main(String[] args) throws Exception {
        SocketD.createServer("sd:tcp")
                .config(c -> c.port(8602).fragmentHandler(new BrokerFragmentHandler()))
                .listen(new BrokerListenerEx())
                .start();
    }
}