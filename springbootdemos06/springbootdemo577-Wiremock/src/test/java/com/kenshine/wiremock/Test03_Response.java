package com.kenshine.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


/**
 * @author by kenshine
 * @Classname Test03_Response
 * @Description 常用的响应的配置
 * @Date 2023-12-14 10:00
 * @modified By：
 * @version: 1.0$
 */
public class Test03_Response {

    /**
     *
     */
    @Test
    public void start() {
        int port = 8091;
        // 实例化wirmockServer对象
        WireMockServer wireMockServer = new WireMockServer(
                wireMockConfig()
                        .port(port)
                        .extensions(new ResponseTemplateTransformer(true))
        );
        // 启动mock服务
        wireMockServer.start();
        configureFor(port);
        stubFor(get(urlEqualTo("/test03"))
                // 配置返回的body，header，statusCode
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-Type", "application/json")
                                .withBody("test03!")
                ));
        // ok()表示返回响应状态码为200
        stubFor(delete("/fine")
                .willReturn(ok()));
        // 返回响应状态码+body
        stubFor(get("/fineWithBody")
                .willReturn(ok("body")));
        // 返回响应体为json格式
        stubFor(get("/returnJson")
                .willReturn(okJson("{\"status\":\"success\"}")));
        // 进行请求重定向
        stubFor(get("/redirect")
                .willReturn(temporaryRedirect("/new/place")));
        // 未鉴权
        stubFor(get("/unauthorized")
                .willReturn(unauthorized()));
        // 配置响应状态码
        stubFor(get("/statusCode")
                .willReturn(status(418)));

        System.out.println("http://localhost:" + port);
        try {
            // 100s
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // wiremock复位
        WireMock.reset();
        // wiremock停止（不停止下一次就无法进行调用了）
        wireMockServer.stop();
    }

}
