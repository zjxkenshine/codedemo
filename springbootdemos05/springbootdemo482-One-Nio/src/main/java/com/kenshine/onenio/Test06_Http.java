package com.kenshine.onenio;

import one.nio.http.HttpClient;
import one.nio.http.HttpException;
import one.nio.http.Request;
import one.nio.http.Response;
import one.nio.net.ConnectionString;
import one.nio.pool.PoolException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname Test06_Http
 * @Description http包
 * @Date 2023-11-14 16:55
 * @modified By：
 * @version: 1.0$
 */
public class Test06_Http {

    /**
     * HttpClient 测试
     */
    @Test
    public void testHttpClient() throws InterruptedException, IOException, HttpException, PoolException {
        HttpClient client = new HttpClient(new ConnectionString("localhost:8080"));
        String path = "/test01";
        Response response = client.get(path);
        System.out.println("Status code: " + response.getStatus());
        System.out.println(response.toString());
        client.close();
    }

    /**
     * HttpHeader 测试
     */
    private static final String HEADER = "X-OK-Custom-Header: ";
    private void testHeaderConsumer(final String... values) {
        final Request request = new Request(Request.METHOD_GET, "/", true);
        for (final String value : values) {
            request.addHeader(HEADER + value);
        }
        // 解析请求头 X-OK-Custom-Header:
        final List<String> sink = new ArrayList<>(values.length);
        request.consumeHeaders(HEADER, sink::add);
        assertEquals(Arrays.asList(values), sink);
        System.out.println(sink);
    }
    @Test
    public void consumeEmpty() {
        testHeaderConsumer();
    }
    @Test
    public void consumeSingle() {
        testHeaderConsumer("Value");
    }
    @Test
    public void consumeDouble() {
        testHeaderConsumer("First", "Second");
    }

    /**
     * method 请求方法
     * Test06_HttpServer服务端
     */
    @Test
    public void testMethod() throws InterruptedException, IOException, HttpException, PoolException {
        String uri="/test";
        HttpClient client=new HttpClient(new ConnectionString("localhost:8080"));
        client.get(uri);
        client.head(uri);
        client.post(uri);
        client.put(uri);
        client.patch(uri);
        client.delete(uri);
        client.connect(uri);
        client.options(uri);
        client.trace(uri);
    }

    /**
     * HttpResponse
     */
    @Test
    public void testHttpResponse(){
        Response response = new Response(Response.OK);
        assertEquals(200, response.getStatus());
        assertEquals(1, response.getHeaderCount());
        assertNull(response.getBody());
        assertEquals(200, response.getStatus());
        assertEquals(2, response.getHeaderCount());
    }

    /**
     * RequestBody
     */
    @Test
    public void testRequestBody() throws InterruptedException, IOException, HttpException, PoolException {
        final String ENDPOINT = "/test";
        final int MAX_REQUEST_BODY_LENGTH = 65536;
        final byte[] body = new byte[MAX_REQUEST_BODY_LENGTH];
        ThreadLocalRandom.current().nextBytes(body);

        HttpClient client=new HttpClient(new ConnectionString("localhost:8080"));
        final Response response = client.put(ENDPOINT, body);
        assertEquals(200, response.getStatus());
        assertArrayEquals(body, response.getBody());
    }
}
