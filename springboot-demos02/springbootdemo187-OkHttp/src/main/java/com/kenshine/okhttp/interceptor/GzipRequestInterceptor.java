package com.kenshine.okhttp.interceptor;

import okhttp3.*;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 11:34
 * @description：
 * @modified By：
 * @version: $
 */
public class GzipRequestInterceptor implements okhttp3.Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (originalRequest.body() == null || originalRequest.header("Content-Encoding") != null) {
            return chain.proceed(originalRequest);
        }

        //重写请求
        Request compressedRequest = originalRequest.newBuilder()
                .header("Content-Encoding", "gzip")
                .method(originalRequest.method(), gzip(originalRequest.body()))
                .build();
        return chain.proceed(compressedRequest);
    }

    private RequestBody gzip(final RequestBody body) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public long contentLength() {
                return -1; // We don't know the compressed length in advance!
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                body.writeTo(gzipSink);
                gzipSink.close();
            }
        };
    }
}
