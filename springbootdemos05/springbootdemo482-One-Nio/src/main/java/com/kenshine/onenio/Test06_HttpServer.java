package com.kenshine.onenio;

import com.kenshine.onenio.config.HttpServerConfigFactory;
import one.nio.http.*;
import one.nio.net.Socket;
import one.nio.net.SslOption;
import one.nio.util.Utf8;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test06_HttpServer
 * @Description HttpServer 服务端
 * @Date 2023-11-14 17:12
 * @modified By：
 * @version: 1.0$
 */
public class Test06_HttpServer extends HttpServer {

    public Test06_HttpServer(HttpServerConfig config, Object... routers) throws IOException {
        super(config, routers);
    }

    /**
     * localhost:8080/test
     */
    @Path("/test")
    public Response handleSimple() {
        return Response.ok("Simple");
    }

    @Path({"/multi1", "/multi2"})
    public void handleMultiple(Request request, HttpSession session) throws IOException {
        Response response = Response.ok("Multiple: " + request.getPath());
        session.sendResponse(response);
    }

    @Path("/param")
    public Response handleParam(@Param("i") int i,
                                @Param("l=123") Long l,
                                @Param(value = "s", required = true) String s,
                                @Header(value = "Host", required = true) String host,
                                @Header("User-Agent") String agent) throws IOException {
        String params = "i = " + i + "\r\nl = " + l + "\r\ns = " + s + "\r\n";
        String headers = "host = " + host + "\r\nagent = " + agent + "\r\n";
        Response response = Response.ok(Utf8.toBytes("<html><body><pre>" + params + headers + "</pre></body></html>"));
        response.addHeader("Content-Type: text/html");
        return response;
    }

    @Path("/session")
    public Response handleSession(HttpSession session) {
        Socket socket = session.socket();
        Boolean reused = socket.getSslOption(SslOption.SESSION_REUSED);
        Integer ticket = socket.getSslOption(SslOption.SESSION_TICKET);

        StringBuilder result = new StringBuilder("SSL session flags:");
        if (reused != null && reused) {
            result.append(" SESSION_REUSED");
        }
        if (ticket != null) {
            if (ticket == 1) {
                result.append(" TICKET_REUSED");
            } else if (ticket == 2) {
                result.append(" OLD_TICKET_REUSED");
            } else if (ticket == 3) {
                result.append(" NEW_TICKET");
            }
        }

        return Response.ok(result.toString());
    }

    public static void main(String[] args) throws Exception {
        HttpServerConfig config;
        if (args.length > 0) {
            config = HttpServerConfigFactory.fromFile(args[0]);
        } else {
            config = HttpServerConfigFactory.create(8080);
        }
        Test06_HttpServer server = new Test06_HttpServer(config);
        server.start();
    }
}
