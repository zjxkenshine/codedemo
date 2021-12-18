package okhttptest;

import com.kenshine.okhttp.listener.CustomEventListener;
import com.kenshine.okhttp.listener.CustomFactoryEventListener;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.security.cert.Certificate;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 10:27
 * @description：测试
 * @modified By：
 * @version: $
 *
 * 1. 自定义监听器 EventListener
 * 2. 监听工厂 EventListener.Factory
 * 3. Https连接
 */
public class OkHttpTest {


    /**
     * 自定义监听器 EventListener
     */
    @Test
    public void test01_CustomListener() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().eventListener(new CustomEventListener()).build();

        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();

        System.out.println("REQUEST 1 (new connection)");
        try (Response response = client.newCall(request).execute()) {
            // Consume and discard the response body.
            response.body().source().readByteString();
        }

        System.out.println("REQUEST 2 (pooled connection)");
        try (Response response = client.newCall(request).execute()) {
            // Consume and discard the response body.
            response.body().source().readByteString();
        }
    }


    /**
     * 并发监听 Factory
     */
    @Test
    public void test02_CustomFactoryListener(){
        //设置Factory
        OkHttpClient client = new OkHttpClient.Builder().eventListenerFactory(CustomFactoryEventListener.FACTORY).build();

        Request request1 = new Request.Builder()
                .url("https://www.baidu.com/")
                .build();

        //异步请求1
        client.newCall(request1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("request2 fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("request1 success");
            }
        });

        //异步请求2
        Request request2 = new Request.Builder()
                .url("https://www.bilibili.com/")
                .build();
        client.newCall(request2).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("request2 fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("request2 success");
            }
        });
    }


    /**
     * 测试Https连接
     * 无效，没有机构颁发的证书
     */
    @Test
    public void test03_Https(){
        OkHttpClient client = new OkHttpClient.Builder()
                .certificatePinner(
                        //CertificatePinner 证书锁定，限制信任哪些证书和证书颁发机构
                        new CertificatePinner.Builder()
                                .add("publicobject.com", "sha256/afwiKY3RxoMmLkuRW1l7QsPZTJPwDS2pdDROQjXw8ig=")
                                .build())
                .build();

        Request request = new Request.Builder()
                .url("https://publicobject.com/robots.txt")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            for (Certificate certificate : response.handshake().peerCertificates()) {
                System.out.println(CertificatePinner.pin(certificate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
