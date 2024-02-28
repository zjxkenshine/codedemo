package com.kenshine.joddhttp;

import jodd.http.HttpProgressListener;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

import java.io.File;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JoddHttpTest
 * @Description JoddHttp使用测试
 * @Date 2024-02-28 10:43
 * @modified By：
 * @version: 1.0$
 */
public class JoddHttpTest {

    /**
     * 简单的Get请求
     */
    @Test
    public void test01(){
        HttpRequest httpRequest = HttpRequest.get("http://jodd.org");
        HttpResponse response = httpRequest.send();
        System.out.println(response);
        // 流式写法
        HttpResponse response1 = HttpRequest.get("http://jodd.org").send();
        System.out.println(response1);
    }

    /**
     * 复杂请求
     *
     * HttpResponse对象有3个方法
     * body() - 返回ISO-8859-1编码的response返回体（上面的访问对应的是jodd的html源码）
     * bodyText() - 返回与响应头中相应编码的response返回体
     * bodyBytes() - 返回返回体的字节码
     */
    @Test
    public void test02(){
        HttpRequest request = new HttpRequest();
        request
                .method("GET")//get请求
                .protocol("http")//协议使用http
                .host("jodd.org")//主机地址
                .port(80)//端口，没有写默认是80
                .path("/api/jsonws/user/get-user-by-id");//访问路径
        System.out.println(request.send());
    }

    /**
     *  传递参数
     */
    @Test
    public void test03(){
        //get访问中直接在URL中传递参数
        HttpResponse response = HttpRequest
                .get("http://srv:8080/api/jsonws/user/get-user-by-id?userId=10194")
                .send();
        System.out.println(response);
        //调用方法的方式传递参数
        HttpResponse response1 = HttpRequest
                .get("http://srv:8080/api/jsonws/user/get-user-by-id")
                .query("userId", "10194")
                .send();
        System.out.println(response1);

        HttpRequest request = new HttpRequest();
        request
                .method("GET")//get请求
                .protocol("http")//协议使用http
                .host("jodd.org")//主机地址
                .port(80);//端口，没有写默认是80
        Map<String, Object[]> httpParams = (Map<String, Object[]>) request.query();
        httpParams.put("userId", new String[] {"10194"});
    }

    /**
     * 鉴权
     */
    @Test
    public void test04(){
        HttpRequest request = new HttpRequest();
        request.method("GET").protocol("http").host("jodd.org").port(80);
        // 账号密码
        request.basicAuthentication("user", "password");
        // token
        request.tokenAuthentication("M4ORM....");
    }

    /**
     * post请求
     */
    @Test
    public void test05(){
        HttpResponse response = HttpRequest
                .post("http://srv:8080/api/jsonws/user/get-user-by-id")
                .form("userId", "10194")
                .send();
        System.out.println(response);
    }

    /**
     * 上传文件
     */
    @Test
    public void test06(){
        HttpRequest httpRequest = HttpRequest
                .post("http://srv:8080/api/jsonws/dlapp/add-file-entry")
                .form(
                        "repositoryId", "10178",
                        "folderId", "11219",
                        "sourceFileName", "a.zip",
                        "mimeType", "application/zip",
                        "title", "test",
                        "description", "Upload test",
                        "changeLog", "testing...",
                        "file",new File("d:\\a.jpg.zip")
                );
        HttpResponse httpResponse = httpRequest.send();
        System.out.println(httpResponse);
    }

    /**
     * 回调监听上传进度
     */
    @Test
    public void test07(){
        HttpResponse response = HttpRequest
                .post("http://localhost:8081/hello")
                .form("file", new File("d:\\a.jpg.zip"))
                //监听上传的进度
                .monitor(new HttpProgressListener() {
                    @Override
                    public void transferred(int i) {
                        System.out.println(i/size);
                    }
                })
                .send();
        System.out.println(response);
    }

    /**
     * GZip解压支持
     */
    @Test
    public void test08(){
        HttpResponse response = HttpRequest
                .get("http://www.liferay.com")
                .acceptEncoding("gzip")
                .send();
        System.out.println(response.unzip());
    }


    /**
     * body传参
     */
    @Test
    public void test09(){
        HttpResponse response = HttpRequest
                .get("http://srv:8080/api/jsonws/invoke")
                .body("{'$user[userId, screenName] = /user/get-user-by-id' : {'userId':'10194'}}")
                .basicAuthentication("test", "test")
                .send();
    }

    /**
     * 编码设置
     */
    @Test
    public void test10(){
        HttpResponse response = HttpRequest
                .get("http://server/index.html")
                .queryEncoding("CP1251")
                .query("param", "value")
                .send();
    }

}
