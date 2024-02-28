package com.kenshine.joddhttp;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.http.net.SocketHttpConnection;
import jodd.http.net.SocketHttpConnectionProvider;
import org.junit.Test;

import java.net.Socket;
import java.net.SocketException;

/**
 * @author by kenshine
 * @Classname ConnectionTest
 * @Description 连接方式
 * @Date 2024-02-28 11:07
 * @modified By：
 * @version: 1.0$
 */
public class ConnectionTest {

    /**
     * Socket连接
     */
    @Test
    public void test01() throws SocketException {
        HttpRequest request = HttpRequest.get("");
        request.open();
        SocketHttpConnection httpConnection = (SocketHttpConnection) request.connection();
        Socket socket = httpConnection.getSocket();
        socket.setSoTimeout(1000);
        HttpResponse response = request.send();
    }

    /**
     * Socket连接 使用ConnectionProvider
     */
    @Test
    public void test02(){
        HttpResponse response = HttpRequest
                .get("")
                .withConnectionProvider(new MyConnectionProvider()).send();
    }

    /**
     * Keep-Alive 长连接
     */
    @Test
    public void test03(){
        HttpRequest request = HttpRequest.get("http://jodd.org");
        HttpResponse response = request.connectionKeepAlive(true).send();
        request = HttpRequest.get("http://jodd.org/jodd.css");
        response = request.keepAlive(response, true).send();
        request = HttpRequest.get("http://jodd.org/jodd.png");
        response = request.keepAlive(response, false).send();
        response.close();
    }

    /**
     * Proxy 代理连接
     */
    @Test
    public void test04(){
        SocketHttpConnectionProvider s = new SocketHttpConnectionProvider();
        s.useProxy(ProxyInfo.httpProxy("proxy_url", 1090, null, null));
        HttpResponse response = HttpRequest
                .get("http://jodd.org/")
                .withConnectionProvider(s)
                .send();
    }


}
