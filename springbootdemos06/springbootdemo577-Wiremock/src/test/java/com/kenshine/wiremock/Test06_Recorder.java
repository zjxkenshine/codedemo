package com.kenshine.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * @author by kenshine
 * @Classname Test06_Recorder
 * @Description 流量录制
 * @Date 2023-12-14 10:22
 * @modified By：
 * @version: 1.0$
 */
public class Test06_Recorder {
    /**
     * 录制
     * http://localhost:8091/__admin/recorder/
     */
    @Test
    public void start() {
        int port = 8091;
        // 实例化wirmockServer对象
        WireMockServer wireMockServer = new WireMockServer(
                wireMockConfig()
                        // 配置端口号
                        .port(port)
                        // 配置全局response模板
                        .extensions(new ResponseTemplateTransformer(true))
        );
        // 启动mock服务
        wireMockServer.start();
        // 这边需要再次设置一下端口号，否则会报错
        configureFor(port);
        // 配置mock服务中的一个stub，类似Charles的mapLocal功能
        stubFor(get(urlEqualTo("/test01"))
                // 配置返回的body，header，statusCode
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("content-Type", "application/json")
                                .withBody("kenshine wiremock test!")
                ));
        System.out.println("http://localhost:" + port);
        // 等待10s，如果不等待就会直接停止服务，就启动不了了
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
