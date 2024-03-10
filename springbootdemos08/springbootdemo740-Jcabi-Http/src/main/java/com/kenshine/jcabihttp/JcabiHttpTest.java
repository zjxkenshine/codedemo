package com.kenshine.jcabihttp;

import com.google.common.net.HttpHeaders;
import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.RestResponse;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * @author by kenshine
 * @Classname JcabiHttpTest
 * @Description 使用测试
 * @Date 2024-03-10 15:10
 * @modified By：
 * @version: 1.0$
 */
public class JcabiHttpTest {
    /**
     * 基本使用示例
     */
    @Test
    public void test() throws IOException {
        String html = new JdkRequest("https://www.google.com/test")
                .uri().path("/users").queryParam("id", 333).back()
                // get请求
                .method(Request.GET)
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_HTML)
                .fetch()
                .as(RestResponse.class)
                .assertStatus(HttpURLConnection.HTTP_OK)
                .body();
        System.out.println(html);
    }
}
