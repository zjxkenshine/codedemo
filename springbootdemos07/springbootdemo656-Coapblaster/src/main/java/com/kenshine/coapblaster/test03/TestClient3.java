package com.kenshine.coapblaster.test03;

import com.google.iot.coap.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author by kenshine
 * @Classname TestClient3
 * @Description 客户端
 * @Date 2024-01-08 10:12
 * @modified By：
 * @version: 1.0$
 */
public class TestClient3 {
    public static void main(String[] args) throws UnsupportedSchemeException {
        LocalEndpointManager manager = new LocalEndpointManager();
        Client client = new Client(manager, "coap://127.0.0.1/");
        Transaction transaction = client.newRequestBuilder()
                .changePath("/time")
                .addOption(Option.OBSERVE)
                .send();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        transaction.registerCallback(executor, new Transaction.Callback() {
            @Override
            public void onTransactionResponse(LocalEndpoint le, Message response) {
                System.out.println(response.getPayloadAsString());
            }
        });
    }
}
