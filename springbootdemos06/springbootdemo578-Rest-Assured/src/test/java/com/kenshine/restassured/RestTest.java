package com.kenshine.restassured;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

/**
 * @author by kenshine
 * @Classname RestTest
 * @Description 使用测试
 * @Date 2023-12-14 12:26
 * @modified By：
 * @version: 1.0$
 */
public class RestTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        given().
                when().
                get("http://httpbin.org/get?name=kenshine").
                then().
                log().body(); //返回响应体中的数据
        //log可以向控制台输出返回的信息
        //log().all() 可以返回所有响应中的数据
    }

    /**
     * queryParam 添加参数
     */
    @Test
    public void test02(){
        given().
                queryParam("name", "kenshine").
                queryParam("age", "18").
                when().
                get("http://httpbin.org/get").
                then().
                log().body();
    }

    /**
     * POST请求 form表单类型
     */
    @Test
    public void test03(){
        given().
                formParam("name", "jay").
                formParam("password", "qwerty").
                when().
                post("http://httpbin.org/post").
                then().
                log().body();
    }

    /**
     * json参数类型
     */
    @Test
    public void test04(){
        String jsonData = "{\"mobilephone\":\"13323234545\",\"password\":\"234545\"}";
        given().
                body(jsonData).
                contentType(ContentType.JSON). //使用body时必须指定类型
                when().
                post("http://httpbin.org/post").
                then().
                log().body();
    }

    /**
     * XML参数类型
     */
    @Test
    public void test05(){
        String xmlStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<suite>\n" +
                " <class>测试xml</class>\n" +
                "</suite>";

        given().
                contentType(ContentType.XML).
                body(xmlStr).
                when().
                post("http://www.httpbin.org/post").
                then().
                log().body();

    }


    /**
     * 上传文件
     */
    @Test
    public void test06(){
        given().
                multiPart(new File("img\\test.jpg")).
                when().
                post("http://httpbin.org/post").
                then().
                log().body();
    }

    /**
     * 响应
     * 通过 extract().response() 将响应结果赋值到一个 Response 类型的变量中。
     * Gpath用来提取响应中的某一个具体的数据
     *      提取JSON：res.jsonPath().get(“data.id”);
     *      提取xml：res.xmlPath().get(“XXX.XXX.XXX”);
     *      提取HTML：res.htmlPath().get(“html.head.meta[0].@content”);
     */
    @Test
    public void test07(){
        String jsonData = "{\"mobilephone\":\"13323234545\",\"password\":\"234545\"}";
        Response res=
                given().
                        contentType(ContentType.JSON).
                        body(jsonData).
                        //headers(Map map)，将JSON格式的多个header，通过fastjson转换成map：Map result = (Map) JSON.parse(JSON_String);
                                when().
                        post("http://httpbin.org/post").
                        then().
                        extract().response();

        //获取接口的响应时间(ms)
        System.out.println(res.time());
        //获取响应头信息
        System.out.println(res.getHeader("Content-Type"));
        //获取响应体信息(Json格式)
        System.out.println(res.jsonPath().getString("lotto.lottoId"));

    }


}
