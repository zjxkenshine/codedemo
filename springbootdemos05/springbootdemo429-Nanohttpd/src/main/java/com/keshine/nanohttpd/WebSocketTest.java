package com.keshine.nanohttpd;

import fi.iki.elonen.NanoWSD;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname WebSocketTest
 * @Description WebSocket测试
 * @Date 2023-10-28 10:30
 * @modified By：
 * @version: 1.0$
 */
public class WebSocketTest {
    public static void main(String[] args) throws IOException {
        final boolean debugMode = args.length >= 2 && "-d".equals(args[1]);
        // 默认9090端口
        NanoWSD ws = new NanoWebSocketApp(args.length > 0 ? Integer.parseInt(args[0]) : 9090, debugMode);
        ws.start();
        System.out.println(ws.getHostname()+":"+ws.getListeningPort());
        System.out.println("Server started, hit Enter to stop.\n");
        try {
            System.in.read();
        } catch (IOException ignored) {
        }
        ws.stop();
        System.out.println("Server stopped.\n");
    }
}
