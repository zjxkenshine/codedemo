package com.kenshine.galimatias;

import io.mola.galimatias.GalimatiasParseException;
import io.mola.galimatias.URL;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 解析URL
 * @Date 2023-10-12 8:56
 * @modified By：
 * @version: 1.0$
 */
public class GalimatiasTest {

    public static void main(String[] args) {
        // url
        String urlString = "http://127.0.0.1:8096";
        URL url;
        try {
            url = URL.parse(urlString);
            System.out.println(url.authority());
            System.out.println(url.path());
            System.out.println(url.port());
            // 转换为java URL URI
            java.net.URL javaURL=url.toJavaURL();
            java.net.URI javaURI=url.toJavaURI();
        } catch (GalimatiasParseException | MalformedURLException | URISyntaxException ex) {
          ex.printStackTrace();
        }
    }

}
