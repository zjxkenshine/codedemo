package com.kenshine.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * @author by kenshine
 * @Classname Test04_Priority
 * @Description 匹配优先级
 * @Date 2023-12-14 10:03
 * @modified By：
 * @version: 1.0$
 */
public class Test04_Priority {
    /**
     * 优先级匹配：
     * 1，匹配优先级高的
     * 2，再按照url进行匹配
     */
    @Test
    public void start() {
        int port = 8093;
        // 实例化wirmockServer对象
        WireMockServer wireMockServer = new WireMockServer(
                wireMockConfig()
                        .port(port)
                        .extensions(new ResponseTemplateTransformer(true))
        );
        // 启动mock服务
        wireMockServer.start();
        configureFor(port);
        // 匹配特定的
        stubFor(get(urlEqualTo("/some/thing")).atPriority(2)
                // 配置返回的body，header，statusCode
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-Type", "application/json")
                                .withBody("this is my first wiremock demo!")
                ));
        // 使用正则进行通配
        stubFor(get(urlMatching("/some/.*")).atPriority(12)
                .willReturn(
                        aResponse()
                                .withStatus(401)
                                .withBody("match any")
                ));
        // 兜底逻辑 atPriority设置优先级
        stubFor(any(anyUrl()).atPriority(1)
                .willReturn(
                        aResponse()
                                .withStatus(402)
                                .withBody("no match")
                ));
        System.out.println("http://localhost:" + port);
        try {
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
