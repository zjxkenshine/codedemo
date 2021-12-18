package okhttptest;

import com.kenshine.okhttp.cache.Authenticate;
import com.kenshine.okhttp.cache.CacheResponse;
import com.kenshine.okhttp.cache.ConfigureTimeouts;
import com.kenshine.okhttp.domain.Gist;
import com.kenshine.okhttp.domain.GistFile;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import okhttp3.*;
import okio.BufferedSink;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 13:44
 * @description：官方案例
 * @modified By：
 * @version: $
 * 1. 同步调用
 * 2. 异步调用
 * 3. 访问请求头
 * 4. 发送一个字符串
 * 5. Post流
 * 6. 发送文件
 * 7. 发送表单参数
 * 8. 发送Multipart请求
 * 9. 使用 Moshi 解析 JSON 响应
 * 10. 响应缓存
 * 11. 取消请求
 * 12. 超时
 * 13. 身份验证
 */
public class DemoTest {
    private final OkHttpClient client = new OkHttpClient();

    /**
     * 同步调用
     */
    @Test
    public void test01() throws Exception {
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            System.out.println(response.body().string());
        }
    }

    /**
     * 异步调用
     */
    @Test
    public void test02() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    System.out.println(responseBody.string());
                }
            }
        });
    }

    /**
     * 3.访问请求头
     */
    @Test
    public void test03() throws IOException {
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            System.out.println("Server: " + response.header("Server"));
            System.out.println("Date: " + response.header("Date"));
            System.out.println("Vary: " + response.headers("Vary"));
        }
    }


    /**
     * 4.发送一个字符串
     */
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    @Test
    public void test04(){
        String postBody = ""
                + "Releases\n"
                + "--------\n"
                + "\n"
                + " * _1.0_ May 6, 2013\n"
                + " * _1.1_ June 15, 2013\n"
                + " * _1.2_ August 11, 2013\n";

        Request request = new Request.Builder()
                .url("http://localhost:8080/test/test04")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Post流
     */
    @Test
    public void test05(){
        RequestBody requestBody = new RequestBody() {
            @Override public MediaType contentType() {
                return MEDIA_TYPE_MARKDOWN;
            }

            @Override public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8("Numbers\n");
                sink.writeUtf8("-------\n");
                for (int i = 2; i <= 997; i++) {
                    sink.writeUtf8(String.format(" * %s = %s\n", i, factor(i)));
                }
            }

            private String factor(int n) {
                for (int i = 2; i < n; i++) {
                    int x = n / i;
                    if (x * i == n) return factor(x) + " × " + i;
                }
                return Integer.toString(n);
            }
        };

        Request request = new Request.Builder()
                .url("http://localhost:8080/test/test04")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文件用作请求正文
     */
    @Test
    public void test06(){
        File file = new File("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo187-OkHttp\\src\\main\\resources\\txt\\test01.txt");

        Request request = new Request.Builder()
                .url("http://localhost:8080/test/test04")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }

            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 7.发布表单参数 FormBody.Builder
     */
    @Test
    public void test07(){
        RequestBody formBody = new FormBody.Builder()
                .add("search", "Kenshine")
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/test/test04")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 8.发布复杂请求(multipart request)
     */
    private static final String IMGUR_CLIENT_ID = "1";
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    @Test
    public void test08() throws Exception {
        // Use the imgur image upload API as documented at https://api.imgur.com/endpoints/image
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "Test Logo")
                .addFormDataPart("image", "logo-square.png",RequestBody.create(MEDIA_TYPE_PNG, new File("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo187-OkHttp\\src\\main\\resources\\img\\1.png")))
                .build();

        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
                .url("http://localhost:8080/test/test08")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            System.out.println(response.body().string());
        }
    }

    /**
     * 9.使用Moshi解析JSON响应
     */
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);
    @Test
    public void test09() throws Exception {
        OkHttpClient client1 = new OkHttpClient().newBuilder().connectTimeout(60000, TimeUnit.MILLISECONDS)
                .readTimeout(60000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:8080/test/test09")
                .get()
                .build();
        try (Response response = client1.newCall(request).execute()) {
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            //response.body().source() 只能调用一次
            Gist gist = gistJsonAdapter.fromJson(response.body().source());
            for (Map.Entry<String, GistFile> entry : gist.getFiles().entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue().getContent());
            }
        }
    }

    /**
     * 10.响应缓存
     */
    @Test
    public void test10() throws Exception {
        OkHttpClient client1=new CacheResponse(new File("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo187-OkHttp\\src\\main\\resources\\cache\\Cache.txt")).getClient();
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        String response1Body = null;
        try (Response response1 = client1.newCall(request).execute()) {
            if (!response1.isSuccessful()){
                throw new IOException("Unexpected code " + response1);
            }

            response1Body = response1.body().string();
            System.out.println("Response 1 response:          " + response1);
            System.out.println("Response 1 cache response:    " + response1.cacheResponse());
            System.out.println("Response 1 network response:  " + response1.networkResponse());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String response2Body = null;
        try (Response response2 = client.newCall(request).execute()) {
            if (!response2.isSuccessful()){
                throw new IOException("Unexpected code " + response2);
            }
            response2Body = response2.body().string();
            System.out.println("Response 2 response:          " + response2);
            System.out.println("Response 2 cache response:    " + response2.cacheResponse());
            System.out.println("Response 2 network response:  " + response2.networkResponse());
        }


        System.out.println("Response 2 equals Response 1? " + response1Body.equals(response2Body));
    }

    /**
     * 11. 取消调用 Call.cancel()
     */
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    @Test
    public void test11(){
        Request request = new Request.Builder()
                //模拟延迟
                .url("http://localhost:8080/test/test11")
                .build();

        final long startNanos = System.nanoTime();
        final Call call = client.newCall(request);

        // 1秒后取消调用 schedule定时队列
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.printf("%.2f Canceling call.%n", (System.nanoTime() - startNanos) / 1e9f);
                call.cancel();
                System.out.printf("%.2f Canceled call.%n", (System.nanoTime() - startNanos) / 1e9f);
            }
        }, 1, TimeUnit.SECONDS);

        System.out.printf("%.2f Executing call.%n", (System.nanoTime() - startNanos) / 1e9f);
        try (Response response = call.execute()) {
            System.out.printf("%.2f Call was expected to fail, but completed: %s%n",
                    (System.nanoTime() - startNanos) / 1e9f, response);
        } catch (IOException e) {
            System.out.printf("%.2f Call failed as expected: %s%n",
                    (System.nanoTime() - startNanos) / 1e9f, e);
        }
    }

    /**
     * 12.Timeouts 超时
     */
    @Test
    public void test12() throws Exception {
        OkHttpClient client1 = new ConfigureTimeouts().getClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/test/test11")
                .build();

        try (Response response = client1.newCall(request).execute()) {
            System.out.println("Response completed: " + response);
        }
    }

    /**
     * 13.身份认证
     */
    @Test
    public void test13() throws Exception {
        OkHttpClient client1 = new Authenticate().getClient();
        Request request = new Request.Builder()
                .url("http://publicobject.com/secrets/hellosecret.txt")
                .build();

        try (Response response = client1.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            System.out.println(response.body().string());
        }
    }




}
