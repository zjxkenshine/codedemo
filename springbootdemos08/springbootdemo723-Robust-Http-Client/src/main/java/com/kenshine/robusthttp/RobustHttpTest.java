package com.kenshine.robusthttp;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jvnet.robust_http_client.RetryableHttpStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname RobustHttpTest
 * @Description 使用测试
 * @Date 2024-03-04 15:35
 * @modified By：
 * @version: 1.0$
 */
public class RobustHttpTest {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        URL url = new URL("http://archive.apache.org/dist/ant/binaries/apache-ant-1.6.5-bin.zip");
        RetryableHttpStream s = new RetryableHttpStream(url) {
            int retry=0;
            @Override
            protected void shallWeRetry() throws IOException {
                System.out.println("Retrying");
                if(retry++>16) {
                    throw new IOException("Too many retries");
                }
            }
        };

        System.out.println("totalLength="+s.totalLength);
        DigestInputStream din = new DigestInputStream(s, MessageDigest.getInstance("MD5"));
        byte[] md5 = din.getMessageDigest().digest();
        din = new DigestInputStream(url.openStream(),MessageDigest.getInstance("MD5"));
    }
}
