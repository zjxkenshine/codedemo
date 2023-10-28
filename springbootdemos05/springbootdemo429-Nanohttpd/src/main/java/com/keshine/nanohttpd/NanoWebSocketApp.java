package com.keshine.nanohttpd;

import fi.iki.elonen.NanoWSD;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author by kenshine
 * @Classname NanoWebsocketApp
 * @Description WebSocket服务器
 * @Date 2023-10-28 10:27
 * @modified By：
 * @version: 1.0$
 */
public class NanoWebSocketApp extends NanoWSD {
    /**
     * logger to log to.
     */
    private static final Logger LOG = Logger.getLogger(NanoWebSocketApp.class.getName());

    private final boolean debug;

    public NanoWebSocketApp(int port, boolean debug) {
        super("localhost",port);
        this.debug = debug;
    }

    public NanoWebSocketApp(String hostname,int port, boolean debug) {
        super(hostname,port);
        this.debug = debug;
    }

    @Override
    protected WebSocket openWebSocket(IHTTPSession handshake) {
        return new DebugWebSocket(this, handshake);
    }

    private static class DebugWebSocket extends WebSocket {

        private final NanoWebSocketApp server;

        public DebugWebSocket(NanoWebSocketApp server, IHTTPSession handshakeRequest) {
            super(handshakeRequest);
            this.server = server;
        }

        @Override
        protected void onOpen() {
        }

        @Override
        protected void onClose(WebSocketFrame.CloseCode code, String reason, boolean initiatedByRemote) {
            if (server.debug) {
                System.out.println("C [" + (initiatedByRemote ? "Remote" : "Self") + "] " + (code != null ? code : "UnknownCloseCode[" + code + "]")
                        + (reason != null && !reason.isEmpty() ? ": " + reason : ""));
            }
        }

        @Override
        protected void onMessage(WebSocketFrame message) {
            try {
                message.setUnmasked();
                sendFrame(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void onPong(WebSocketFrame pong) {
            if (server.debug) {
                System.out.println("P " + pong);
            }
        }

        @Override
        protected void onException(IOException exception) {
            NanoWebSocketApp.LOG.log(Level.SEVERE, "exception occured", exception);
        }

        @Override
        protected void debugFrameReceived(WebSocketFrame frame) {
            if (server.debug) {
                System.out.println("R " + frame);
            }
        }

        @Override
        protected void debugFrameSent(WebSocketFrame frame) {
            if (server.debug) {
                System.out.println("S " + frame);
            }
        }
    }
}
