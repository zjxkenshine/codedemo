package com.kenshine.rsocket;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketConnector;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

/**
 * @author by kenshine
 * @Classname RSocketClient1
 * @Description rsocket使用测试1
 * @Date 2024-05-29 19:47
 * @modified By：
 * @version: 1.0$
 */
public class RSocketClient1 {

    public static void main(String[] args) {
        RSocket rsocket =
                new RSocket() {
                    boolean fail = true;

                    @Override
                    public Mono<Payload> requestResponse(Payload p) {
                        if (fail) {
                            fail = false;
                            return Mono.error(new Throwable("Simulated error"));
                        } else {
                            return Mono.just(p);
                        }
                    }
                };
        // server
        RSocketServer.create(SocketAcceptor.with(rsocket))
                .bindNow(TcpServerTransport.create("localhost", 8080));
        // 连接
        RSocket socket =
                RSocketConnector.connectWith(TcpClientTransport.create("localhost", 8080)).block();

        for (int i = 0; i < 3; i++) {
            socket
                    .requestResponse(DefaultPayload.create("Hello"))
                    .map(Payload::getDataUtf8)
                    .onErrorReturn("error")
                    .doOnNext(System.out::println)
                    .block();
        }

        socket.dispose();
    }
}
