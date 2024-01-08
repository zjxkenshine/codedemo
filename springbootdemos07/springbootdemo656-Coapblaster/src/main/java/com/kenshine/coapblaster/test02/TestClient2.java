package com.kenshine.coapblaster.test02;

import com.google.iot.coap.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author by kenshine
 * @Classname TestClient2
 * @Description 客户端
 * @Date 2024-01-08 10:03
 * @modified By：
 * @version: 1.0$
 */
public class TestClient2 {
    public static void main(String[] args) throws InterruptedException, TimeoutException, HostLookupException, IOException, UnsupportedSchemeException {
        LocalEndpointManager manager = new LocalEndpointManager();
        Client client = new Client(manager, "coap://127.0.0.1/test/hello");
        Transaction transaction = client.newRequestBuilder().send();
        Message response = transaction.getResponse();
        System.out.println(response);
        System.out.println("Got response: " + response.getPayloadAsString());
    }
}
