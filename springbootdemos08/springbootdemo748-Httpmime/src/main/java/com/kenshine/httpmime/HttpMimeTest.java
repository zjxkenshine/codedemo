package com.kenshine.httpmime;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author by kenshine
 * @Classname HttpMimeTest
 * @Description 使用测试
 * @Date 2024-03-15 8:37
 * @modified By：
 * @version: 1.0$
 */
public class HttpMimeTest {

    /**
     * 发送get请求
     */
    @Test
    public void test01(){
        HttpMimeHelper httpMimeHelper = new HttpMimeHelper();
        String result = httpMimeHelper.getWithHttp(null, "https://httpbin.org/#/HTTP_Methods/get", "");
        System.out.println(result);
    }

    /**
     * 发送post请求
     */
    @Test
    public void test02(){
        HttpMimeHelper httpMimeHelper = new HttpMimeHelper();
        String result = httpMimeHelper.postWithHttp(null, "https://httpbin.org/#/HTTP_Methods/post");
        System.out.println(result);
    }

    /**
     * 表单提交post请求
     */
    @Test
    public void test03(){
        HttpMimeHelper httpMimeHelper = new HttpMimeHelper();
        String result = httpMimeHelper.postFormWithHttp(new HashMap<>(), "https://httpbin.org/#/HTTP_Methods/post/forms/post","");
        System.out.println(result);
    }

}
