package com.kenshine.socketd.test03;

import org.noear.socketd.SocketD;
import org.noear.socketd.broker.BrokerFragmentHandler;
import org.noear.socketd.broker.BrokerListener;

/**
 * @author kenshine
 * 启动多个 Broker 服务
 */
public class BrokerDemo {
    public static void main(String[] args) throws Exception {
        //是否复用，按需决定
        BrokerListener brokerListener = new BrokerListener();
        
        SocketD.createServer("sd:tcp")
                .config(c -> c.port(8603).fragmentHandler(new BrokerFragmentHandler()))
                .listen(brokerListener)
                .start();
        
        //这只是示例哦
//        SocketD.createServer("sd:ws")
//                .config(c -> c.port(8604).fragmentHandler(new BrokerFragmentHandler()))
//                .listen(brokerListener)
//                .start();
    }
}