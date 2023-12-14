package com.kenshine.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;

import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test02_RequestMatching
 * @Description 常用的请求体的配置
 * @Date 2023-12-14 8:53
 * @modified By：
 * @version: 1.0$
 */
public class Test02_RequestMatching{

    /**
     * RequestMatching 请求体配置
     * wireMock的管理后台 http://localhost:8090/__admin
     */
    @Test
    public void start() {
        int port = 8090;
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
        /**
         *   配置mock服务中的一个stub，类似Charles的mapLocal功能
         *   这些配置是“且”的关系，必须全部满足，才能请求成功
         */
        // url的路径等于"everything"’
        stubFor(any(urlPathEqualTo("everything"))
                //通过header匹配规则
                .withHeader("Accept", containing("xml"))
                //通过cookie匹配规则
                .withCookie("session", matching(".*12345.*"))
                //通过QueryParam匹配规则
                .withQueryParam("search_term", equalTo("WireMock"))
                //通过withBasicAuth匹配规则
                .withBasicAuth("kenshine@example.com", "kenshine")
                //通过RequestBody匹配规则
                .withRequestBody(matchingJsonPath("$.a", equalTo("1")))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", "text/plain")
                        .withBody("pass!")));
        System.out.println("http://localhost:" + port);
        // 等待10s，如果不等待就会直接停止服务，就启动不了了
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // wiremock复位
        WireMock.reset();
        // wiremock停止（不停止下一次就无法进行调用了）
        wireMockServer.stop();
    }

    /**
     * 测试请求 使用rest-assured
     */
    @Test
    public void testRequestMatching() {
        given().log().all()
                .auth().preemptive().basic("kenshine@example.com", "kenshine")
                .header("Accept", "xml")
                .cookie("session", "123456")
                .body("{\"a\":1,\"b\":2}")
                .queryParam("search_term", "WireMock")
                .when()
                .post("http://localhost:8099/everything").
                then().log().all()
                .extract();
    }


}
