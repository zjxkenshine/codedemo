package com.kenshine.coapblaster.test02;

import com.google.iot.coap.*;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname TestServer2
 * @Description 服务端
 * @Date 2024-01-08 10:03
 * @modified By：
 * @version: 1.0$
 */
public class TestServer2 {

    public static void main(String[] args) throws IOException, UnsupportedSchemeException {
        LocalEndpointManager manager = new LocalEndpointManager();
        Server server = new Server(manager);
        LocalEndpoint udpEndpoint = manager.getLocalEndpointForScheme(Coap.SCHEME_UDP);
        server.addLocalEndpoint(udpEndpoint);
        Resource<InboundRequestHandler> rootResource = new Resource<>();
        Resource<InboundRequestHandler> testFolder = new Resource<>();
        InboundRequestHandler helloHandler = new InboundRequestHandler() {
            @Override
            public void onInboundRequest(InboundRequest inboundRequest) {
                inboundRequest.sendSimpleResponse(Code.RESPONSE_CONTENT, "Hello, World!");
            }
        };
        testFolder.addChild("hello", helloHandler);
        rootResource.addChild("test", testFolder);
        server.setRequestHandler(rootResource);
        server.start();
    }
}
