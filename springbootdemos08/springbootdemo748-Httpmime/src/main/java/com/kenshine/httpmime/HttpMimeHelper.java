package com.kenshine.httpmime;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname HttpMimeTest
 * @Description 本地http请求帮助类
 * @Date 2024-03-15 8:19
 * @modified By：
 * @version: 1.0$
 */
public class HttpMimeHelper {
    private static final Logger logger = LoggerFactory.getLogger(HttpMimeHelper.class);

    /**
     * http post请求，json格式传输参数
     *
     * @param map 参数对
     * @param url url地址
     * @return
     * @throws IOException
     */
    public String postWithHttp(Map<String, Object> map, String url) {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpPost.setConfig(requestConfig);
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(map), "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");

        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                return EntityUtils.toString(resEntity);
            }
        } catch (IOException e) {
            logger.error("", e);
        }
        return "";
    }

    /**
     * 表单提交 post请求
     *
     * @param map 参数对
     * @param url url
     * @param token token
     * @return 响应流
     * @throws IOException
     */
    public String postFormWithHttp(Map<String, Object> map, String url, String token) {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpPost.setConfig(requestConfig);

        httpPost.setHeader("token", token);
        ContentType contentType = ContentType.create("text/plain", Consts.UTF_8);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            builder.addPart(entry.getKey(), new StringBody(entry.getValue().toString(), contentType));
        }
        HttpEntity httpEntity = null;
        try {
            httpEntity = builder.setCharset(CharsetUtils.get("UTF-8")).build();
        } catch (UnsupportedEncodingException e) {
            logger.error("", e);
        }
        httpPost.setEntity(httpEntity);

        return execute(client, httpPost);
    }

    /**
     * get请求
     *
     * @param map 参数对
     * @param url url
     * @param token token
     * @return 响应流
     * @throws IOException
     */
    public String getWithHttp(Map<String, Object> map, String url, String token) {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpGet.setConfig(requestConfig);
        httpGet.setHeader("token", token);
        return execute(client, httpGet);
    }

    /**
     * 执行请求并响应
     *
     * @param client client
     * @param httpPost httpPost
     * @return 结果流字符串
     */
    private String execute(CloseableHttpClient client, HttpRequestBase httpPost) {
        if (client == null || httpPost == null) {
            return "";
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                return EntityUtils.toString(resEntity);
            }
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            try {
                assert response != null;
                response.close();
            } catch (IOException ignored) {
            }
        }
        return "";
    }

    /**
     * 文件下载
     *
     * @param url url
     * @param token token
     * @return 响应流
     * @throws IOException
     */
    public boolean downFileByGet(String url, String token, File targetFile) {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpGet.setConfig(requestConfig);

        httpGet.setHeader("token", token);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            logger.error("", e);
        }
        assert response != null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            try {
                // 写入文件
                response.getEntity().writeTo(new FileOutputStream(targetFile));
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return true;
    }

}
