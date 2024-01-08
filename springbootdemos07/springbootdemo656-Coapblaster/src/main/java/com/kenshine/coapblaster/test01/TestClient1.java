package com.kenshine.coapblaster.test01;

import com.google.iot.coap.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author by kenshine
 * @Classname TestClient1
 * @Description 获取资源
 * @Date 2024-01-08 10:00
 * @modified By：
 * @version: 1.0$
 */
public class TestClient1 {

    /**
     * Coap客户端获取大资源
     */
    public static void main(String[] args) throws UnsupportedSchemeException, InterruptedException, TimeoutException, HostLookupException, IOException {
        LocalEndpointManager manager = new LocalEndpointManager();
        Client client = new Client(manager, "coap://coap.me/");
        Transaction transaction = client.newRequestBuilder()
                .changePath("/large")
                .send();
        Message response = transaction.getResponse();
        System.out.println(response.getPayloadAsString());
    }
}
