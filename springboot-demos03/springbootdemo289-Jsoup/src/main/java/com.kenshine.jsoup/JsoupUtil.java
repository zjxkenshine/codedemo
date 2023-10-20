package com.kenshine.jsoup;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author by kenshine
 * @Classname JsoupUtil
 * @Description 解析Document
 * @Date 2023-10-20 17:00
 * @modified By：
 * @version: 1.0$
 */
public class JsoupUtil {

    public static Document getDoc1(String url){
        try {
            Document doc = Jsoup.connect(url)
                    .header("Accept-Encoding", "gzip, deflate")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0)Gecko/20100101 Firefox/23.0")
                    .maxBodySize(0)
                    .timeout(600000000)
                    .get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Document getDoc2(String str) throws Exception    {
        URL url = new URL(str);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream =  conn.getInputStream();
        byte[] data = readInputStream(inStream);
        String htmlSource = new String(data);
        return Jsoup.parse(htmlSource);
    }

    private static byte[] readInputStream(InputStream inStream) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024*4];
        int n = 0;
        while (-1 != (n = inStream.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    /**
     * 使用htmlunit
     */
    public static Document getDoc3(String url) throws Exception {
        String ret = "";
        //模拟创建打开一个谷歌浏览器窗口
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //设置网页响应时间,毫秒
        webClient.getOptions().setTimeout(15000);
        //是否开启ssl
        webClient.getOptions().setUseInsecureSSL(true);
        //是否自动加载重定向
        webClient.getOptions().setRedirectEnabled(true);
        //是否抛出页面javascript错误
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        //是否抛出response的错误
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        // HtmlUnit对JavaScript的支持不好，关闭之
        webClient.getOptions().setJavaScriptEnabled(false);
        // HtmlUnit对CSS的支持不好，关闭之
        webClient.getOptions().setCssEnabled(false);
        WebRequest webRequest = new WebRequest(new URL(url));
        webRequest.setHttpMethod(HttpMethod.GET);
        HtmlPage page = webClient.getPage(webRequest);
        webClient.waitForBackgroundJavaScript(1000);
        ret = page.asXml();
        webClient.close();
        return Jsoup.parse(ret);
    }



}
