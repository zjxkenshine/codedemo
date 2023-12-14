package com.kenshine.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;
import org.junit.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * @author by kenshine
 * @Classname Test05_Proxy
 * @Description 使用代理协议转发请求并返回真实内容
 * @Date 2023-12-14 10:14
 * @modified By：
 * @version: 1.0$
 */
public class Test05_Proxy {

    /**
     * 流量录制
     * http://localhost:8021/__admin/recorder/
     * 代理访问 https://httpbin.ceshiren.com
     */
    @Test
    public void start() {
        int port = 8021;
        // 实例化wirmockServer对象
        WireMockServer wireMockServer = new WireMockServer(
                wireMockConfig()
                        // 配置端口号
                        .port(port)
                        // 配置全局response模板
                        .extensions(new ResponseTemplateTransformer(true),
                                // 新建一个response的处理器
                                new ResponseTransformer() {
                                    // 对response里的文本进行替换
                                    @Override
                                    public Response transform(Request request, Response response, FileSource fileSource, Parameters parameters) {
                                        return Response.Builder.like(response)
                                                .body(response.getBodyAsString().replace("Other Utilities","My proxy Utilities"))
                                                .build();
                                    }

                                    @Override
                                    public String getName() {
                                        return "proxy demo";
                                    }
                                })
        );
        // 启动mock服务
        wireMockServer.start();
        configureFor(port);
        // 配置mock服务中的一个stub
        stubFor(get(urlMatching("/.*"))
                .willReturn(
                        aResponse()
                                // 设置代理
                                .proxiedFrom("https://httpbin.ceshiren.com")
                ));
        System.out.println("http://localhost:" + port);
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // wiremock复位
        WireMock.reset();
        // wiremock停止（不停止下一次就无法进行调用了）
        wireMockServer.stop();
    }

}
