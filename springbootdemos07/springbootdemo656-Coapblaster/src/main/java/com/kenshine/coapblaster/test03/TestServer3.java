package com.kenshine.coapblaster.test03;

import com.google.iot.coap.*;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author by kenshine
 * @Classname testServer3
 * @Description 服务器
 * @Date 2024-01-08 10:10
 * @modified By：
 * @version: 1.0$
 */
public class TestServer3 {

    public static void main(String[] args) throws IOException, UnsupportedSchemeException {
        LocalEndpointManager manager = new LocalEndpointManager();
        Server server = new Server(manager);
        LocalEndpoint udpEndpoint = manager.getLocalEndpointForScheme(Coap.SCHEME_UDP);
        server.addLocalEndpoint(udpEndpoint);
        Resource<InboundRequestHandler> rootResource = new Resource<>();
        Observable observable = new Observable();
        InboundRequestHandler timeHandler = new InboundRequestHandler() {
            @Override
            public void onInboundRequest(InboundRequest inboundRequest) {
                if (!observable.handleInboundRequest(inboundRequest)){
                    inboundRequest.sendSimpleResponse(
                            Code.RESPONSE_CONTENT,
                            "ms: " + System.currentTimeMillis());
                }
            }
        };
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(observable::trigger, 1, 1, TimeUnit.SECONDS);
        rootResource.addChild("time", timeHandler);
        server.setRequestHandler(rootResource);
        System.out.println("start");
        server.start();
    }
}
