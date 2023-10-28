package com.kenshine.fluenthc;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.time.Duration;

/**
 * @author by kenshine
 * @Classname FluentTest
 * @Description 测试
 * @Date 2023-10-28 13:24
 * @modified By：
 * @version: 1.0$
 */
public class FluentTest {
    private final RetryPolicy<Object> retryPolicy = new RetryPolicy<>()
            //如果获得这个异常，则执行重试
            .handle(SocketTimeoutException.class)
            //延迟俩秒
            .withDelay(Duration.ofSeconds(2))
            //最多尝试俩次
            .withMaxRetries(2);

    private final int DEFAULT_CONNECT_TIMEOUT=10000;
    private final int DEFAULT_SOCKET_TIMEOUT=10000;

    /**
     * get请求
     */
    @Test
    public void test01(){
        String url = "http://localhost:8080/test01";
        //传入重试机制
        String content = Failsafe.with(retryPolicy).get(() ->
                //构建一个get请求
                //请求connectTimeout()设置连接超时
                //socketTimeout() 设置文本读取超时
                //execut() 执行远程连接的核心方法，就是发起一个HttpRequest并返回一个HttpResponse
                //returnContent() 获取返回请求结果Content,其实也就是流文本
                Request.Get(url)
                        .connectTimeout(1000)
                        .socketTimeout(500)
                        .execute().returnContent().asString()
        );
        System.out.println(content);
    }

    /**
     * post请求
     */
    @Test
    public void test02(){
        String url = "http://localhost:8080/test02";
        String dataJson="{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"kenshine\"\n" +
                "}";
        String content = Failsafe.with(retryPolicy).get(() ->
                //构建一个post请求
                //请求体body可以使用方法bodyString()按照文本格式传入即可
                // 如：json字符串的文本类型APPLICATION_JSON
                //设置连接时间和文本读取时间，
                //execute执行这个请求获得respond
                Request.Post(url)
                        .bodyString(dataJson, ContentType.APPLICATION_JSON)
                        .connectTimeout(DEFAULT_CONNECT_TIMEOUT)
                        .socketTimeout(DEFAULT_SOCKET_TIMEOUT)
                        .execute().returnContent().asString()
        );
        System.out.println(content);
    }

    @Test
    public void test03() throws IOException {
        String url = "http://localhost:8080/test02";
        // 处理response
        Document result =Request.Get(url).execute().handleResponse(response -> {
            // 处理response逻辑，生成Document
            return new DocumentImpl();
        });
        System.out.println(result);
    }

}
