package com.kenshine.joddhttp;

import jodd.http.net.SocketHttpConnectionProvider;

import java.io.IOException;
import java.net.Socket;

/**
 *  创建Socket连接
 * @author kenshine
 */
public class MyConnectionProvider extends SocketHttpConnectionProvider {
    public Socket createSocket(String host, int port) throws IOException {
        Socket socket = super.createSocket(host, port,1000);
        socket.setSoTimeout(1000);
        return socket;
    }
}