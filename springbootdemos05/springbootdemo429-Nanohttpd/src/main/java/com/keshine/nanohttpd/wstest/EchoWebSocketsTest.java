package com.keshine.nanohttpd.wstest;

import com.keshine.nanohttpd.NanoWebSocketApp;
import com.keshine.nanohttpd.WebSocketTest;
import fi.iki.elonen.NanoWSD;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * websocket测试
 */
public class EchoWebSocketsTest {

    private static NanoWSD server;

    @BeforeClass
    public static void setUp() throws Exception {
        EchoWebSocketsTest.server = new NanoWebSocketApp(9191, true);
        EchoWebSocketsTest.server.start();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        EchoWebSocketsTest.server.stop();
    }

    @Test
    public void testDirectoryArgument() throws IOException, InterruptedException {
        final String testPort = "9458";

        PipedOutputStream stdIn = new PipedOutputStream();
        System.setIn(new PipedInputStream(stdIn));

        Thread testServer = new Thread(new Runnable() {

            @Override
            public void run() {
                String[] args = {
                    testPort,
                    "-d"
                };
                try {
                    WebSocketTest.main(args);
                } catch (IOException e) {
                    fail("Exception: " + e.getMessage());
                }
            }
        });

        testServer.start();
        Thread.sleep(1000);
        stdIn.write(System.getProperty("line.separator").getBytes());
        testServer.join(1000);
        assertFalse("Test server failed to close", testServer.isAlive());
    }

    /**
     * 客户端连接WebSocket
     *
     */
    @Test
    public void testWebsocketClient() {
        String destUri = "ws://localhost:9191";

        WebSocketClient client = new WebSocketClient();
        SimpleEchoSocket socket = new SimpleEchoSocket();
        socket.getToSendMessages().add("Hello");
        socket.getToSendMessages().add("Thanks for the conversation.");
        socket.getToSendMessages().add(createString(31000));
        socket.getToSendMessages().add(createString(65400));
        try {
            client.start();
            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);
            socket.awaitClose(5, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Assert.assertEquals(4, socket.getReceivedMessages().size());
        Assert.assertEquals("Hello", socket.getReceivedMessages().get(0));
        Assert.assertEquals("Thanks for the conversation.", socket.getReceivedMessages().get(1));
    }

    private String createString(int i) {
        StringBuilder builder = new StringBuilder();
        while (builder.length() < i) {
            builder.append("A very long text.");
        }
        return builder.toString();
    }
}